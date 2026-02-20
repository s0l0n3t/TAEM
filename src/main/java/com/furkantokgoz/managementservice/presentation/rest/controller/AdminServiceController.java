package com.furkantokgoz.managementservice.presentation.rest.controller;


import com.furkantokgoz.managementservice.domain.model.AdminServiceRequest;
import com.furkantokgoz.managementservice.domain.model.AdminServiceResponse;
import com.furkantokgoz.managementservice.domain.model.ServiceResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/adminservice")
public class AdminServiceController {

    private final Map<String, AdminServiceResponse> serviceResponseMap = new HashMap<>();//demo db


    @GetMapping("/{id}")
    public EntityModel<AdminServiceResponse> get(@PathVariable String id) {
        return toModel(serviceResponseMap.get(id)).add(linkTo(methodOn(AdminServiceController.class).get(id)).withSelfRel());
    }
    @PostMapping()
    public ResponseEntity<EntityModel<AdminServiceResponse>> create(@RequestBody AdminServiceRequest adminServiceRequest) {
        String id = UUID.randomUUID().toString();
        AdminServiceResponse adminServiceResponse = new AdminServiceResponse(id, adminServiceRequest.getUsername(), adminServiceRequest.getPassword());
        serviceResponseMap.put(id, adminServiceResponse);
        return ResponseEntity.created(linkTo(methodOn((AdminServiceController.class)).get(id)).toUri()).body(toModel(adminServiceResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable String id) {
        if(!serviceResponseMap.containsKey(id)) {
            throw new NoSuchElementException(HttpStatus.NOT_FOUND.toString());
        }
        serviceResponseMap.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<EntityModel<AdminServiceResponse>> update(@PathVariable String id,@RequestBody AdminServiceRequest adminServiceRequest) {
        if(!serviceResponseMap.containsKey(id)) {
            throw new NoSuchElementException(HttpStatus.NOT_FOUND.toString());
        }
        AdminServiceResponse adminServiceResponse = new AdminServiceResponse(UUID.randomUUID().toString(), adminServiceRequest.getUsername(), adminServiceRequest.getPassword());
        serviceResponseMap.put(adminServiceResponse.getId(), adminServiceResponse);


    }



    private EntityModel<AdminServiceResponse> toModel(AdminServiceResponse adminServiceResponse) {

        //toModel link references
        return EntityModel.of(adminServiceResponse,
                linkTo(methodOn(AdminServiceController.class).get(adminServiceResponse.getId())).withSelfRel(),
                linkTo(methodOn(AdminServiceController.class).get(adminServiceResponse.getId())).withRel("create"));
    }
}
