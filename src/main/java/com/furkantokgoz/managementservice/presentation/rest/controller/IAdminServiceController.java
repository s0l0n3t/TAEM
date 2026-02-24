package com.furkantokgoz.managementservice.presentation.rest.controller;

import com.furkantokgoz.managementservice.domain.model.AdminServiceRequest;
import com.furkantokgoz.managementservice.domain.model.AdminServiceResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AdminService API", description = "Admin user operations")
@RequestMapping("/api/admin")
public interface IAdminServiceController {

    @GetMapping("/{id}")
    public EntityModel<AdminServiceResponse> get(@PathVariable String id);

    @PostMapping
    public ResponseEntity<EntityModel<AdminServiceResponse>> create(@RequestBody AdminServiceRequest adminServiceRequest);

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable String id);

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<AdminServiceResponse>> update(@PathVariable String id,@RequestBody AdminServiceRequest adminServiceRequest);
}
