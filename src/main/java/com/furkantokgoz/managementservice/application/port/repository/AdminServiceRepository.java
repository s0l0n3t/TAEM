package com.furkantokgoz.managementservice.application.port.repository;

import com.furkantokgoz.managementservice.application.command.AdminServiceCommand;

public interface AdminServiceRepository {

    public AdminServiceCommand findById(String id);
    public AdminServiceCommand findByUsername(String username);
    public AdminServiceCommand save(AdminServiceCommand adminServiceCommand);
}
