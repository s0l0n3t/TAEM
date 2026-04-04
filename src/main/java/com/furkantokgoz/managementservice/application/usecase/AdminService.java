package com.furkantokgoz.managementservice.application.usecase;

import com.furkantokgoz.managementservice.application.command.AdminServiceCommand;
import com.furkantokgoz.managementservice.application.port.repository.AdminServiceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {

    private final AdminServiceRepository adminRepository;

    public AdminService(AdminServiceRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminServiceCommand save(AdminServiceCommand adminServiceCommand) {
        return adminRepository.save(new AdminServiceCommand(adminServiceCommand.getUsername(),adminServiceCommand.getPassword(), UUID.randomUUID().toString()));
    }

}
