package com.furkantokgoz.managementservice.infrastructure.adapter.out;

import com.furkantokgoz.managementservice.application.port.repository.AdminRepository;
import com.furkantokgoz.managementservice.domain.model.Admin;
import com.furkantokgoz.managementservice.infrastructure.adapter.out.persistence.AdminRepositoryImpl;

public class AdminRepositoryAdapter implements AdminRepository {

    private final AdminRepositoryImpl jpaAdminRepository;
    //add mapper

    public AdminRepositoryAdapter(AdminRepositoryImpl jpaAdminRepository) {
        this.jpaAdminRepository = jpaAdminRepository;
    }

    @Override
    public Admin findById(String id) {
        return null;
    }

    @Override
    public Admin findByUsername(String username) {
        return null;
    }

    @Override
    public Admin save(Admin adminEntityModel) {
        return null;
        //domain pojo to entity

        //jpa repository save feature

        //Entity to pojo domain object and return pojo domain object
    }
    public boolean existsByUsername(String username) {
        return false;
    }
}
