package com.furkantokgoz.managementservice.application.port.repository;

import com.furkantokgoz.managementservice.application.command.AdminCommand;
import com.furkantokgoz.managementservice.domain.model.Admin;

public interface AdminRepository {

    public Admin findById(String id);
    public Admin findByUsername(String username);
    public Admin save(Admin adminEntityModel);
    public boolean existsByUsername(String username);
}
