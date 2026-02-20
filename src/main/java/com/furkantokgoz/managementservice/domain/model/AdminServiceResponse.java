package com.furkantokgoz.managementservice.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminServiceResponse {
    private String id;
    private String username;
    private String password;
}
