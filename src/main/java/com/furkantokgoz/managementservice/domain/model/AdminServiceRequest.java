package com.furkantokgoz.managementservice.domain.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminServiceRequest {
    @NotBlank(message = "Username cannot be blank") private String username;
    @NotBlank(message = "Password cannot be blank") private String password;
}
