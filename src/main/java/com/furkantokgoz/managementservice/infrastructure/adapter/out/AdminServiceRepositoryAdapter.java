package com.furkantokgoz.managementservice.infrastructure.adapter.out;

import com.furkantokgoz.managementservice.application.command.AdminServiceCommand;
import com.furkantokgoz.managementservice.application.port.repository.AdminServiceRepository;
import com.furkantokgoz.managementservice.infrastructure.adapter.out.persistence.AdminRepositoryImpl;

public class AdminServiceRepositoryAdapter implements AdminServiceRepository {

    private final AdminRepositoryImpl jpaAdminRepository;
    //mapper

    public AdminServiceRepositoryAdapter(AdminRepositoryImpl jpaAdminRepository) {
        this.jpaAdminRepository = jpaAdminRepository;
    }

    @Override
    public AdminServiceCommand findById(String id) {
        return null;
    }

    @Override
    public AdminServiceCommand findByUsername(String username) {
        return null;
    }

    @Override
    public AdminServiceCommand save(AdminServiceCommand adminServiceCommand) {
        return null;
    }
}
