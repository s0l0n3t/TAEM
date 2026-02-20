package com.furkantokgoz.managementservice.presentation.rest.controller;


import com.furkantokgoz.managementservice.domain.model.ServiceRequest;
import com.furkantokgoz.managementservice.domain.model.ServiceResponse;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.parser.Entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.security.Provider;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/workflowservice")
public class ServiceController {

    private final Map<String, ServiceResponse> serviceResponseMap = new HashMap<>(); //demo db

    @GetMapping("/{id}")
    public EntityModel<ServiceResponse> get(@PathVariable String id) {
        //business layer needed
        return toModel(ServiceResponse.builder().id(id).build()); //demo object defined
    };

    @PutMapping("/{id}")
    public EntityModel<ServiceResponse> update(@PathVariable String id, @RequestBody ServiceRequest serviceRequest) {
        if(!serviceResponseMap.containsKey(id)) {
            throw new NoSuchElementException("Service not found");
        }
        ServiceResponse serviceResponse = ServiceResponse.builder().id(id)
                .dataFileName(serviceRequest.getDataFileName())
                .serviceDescription(serviceRequest.getServiceDescription())
                .serviceEndDate(serviceRequest.getServiceEndDate())
                .serviceName(serviceRequest.getServiceName())
                .serviceStartDate(serviceRequest.getServiceStartDate())
                .build();
        serviceResponseMap.put(id, serviceResponse);

        return EntityModel.of(serviceResponse, linkTo(methodOn(ServiceController.class).get(id)).withSelfRel());
        //I'm not sure for output.
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if(!serviceResponseMap.containsKey(id)) {
            throw new NoSuchElementException("Service not found");
        }
        serviceResponseMap.remove(id);
        //return ResponseEntity.ok(linkTo(methodOn(ServiceController.class).delete(id)).withSelfRel());
        return ResponseEntity.notFound().build();//Enterprise approach
    }

    @GetMapping("/getService")
    public CollectionModel<EntityModel<ServiceResponse>> getAll() {
        List<EntityModel<ServiceResponse>> entityModelList = serviceResponseMap.values().stream()
                .map(this::toModel)
                .toList();

        return CollectionModel.of(entityModelList,
                linkTo(methodOn(ServiceController.class).getAll()).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<EntityModel<ServiceResponse>> create(@RequestBody ServiceRequest serviceRequest) {
        String id = UUID.randomUUID().toString();

        serviceResponseMap.put(id,ServiceResponse.builder().id(id)
                .serviceName("demoCompany")
                .dataFileName("demoCompany"+ LocalDateTime.now().toString())
                .serviceStartDate(ZonedDateTime.now())
                .serviceEndDate(LocalDateTime.now().plusDays(2).atZone(ZoneId.systemDefault()))
                .build());

        EntityModel<ServiceResponse> entityResponseModel = toModel(serviceResponseMap.get(id));
        return ResponseEntity.created(linkTo(methodOn(ServiceController.class).get(id)).toUri())
                .body(entityResponseModel);
    }


    // Converting to EntityModel Class
    private EntityModel<ServiceResponse> toModel(ServiceResponse serviceResponse) {
        return EntityModel.of(serviceResponse,
                linkTo(methodOn(ServiceController.class).get(serviceResponse.getId())).withSelfRel(),
                linkTo(methodOn(ServiceController.class).delete(serviceResponse.getId())).withRel("delete"),
                linkTo(methodOn(ServiceController.class).update(serviceResponse.getId(),new ServiceRequest())).withRel("update"),
                linkTo(methodOn(ServiceController.class).getAll()).withRel("getAll"));
    };
}
