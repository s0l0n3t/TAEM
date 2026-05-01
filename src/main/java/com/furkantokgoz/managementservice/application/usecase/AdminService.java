package com.furkantokgoz.managementservice.application.usecase;

import com.furkantokgoz.managementservice.application.command.AdminCommand;
import com.furkantokgoz.managementservice.application.port.repository.AdminRepositoryPort;
import com.furkantokgoz.managementservice.domain.model.Admin;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {


    private final AdminRepositoryPort adminRepositoryPort;

    public AdminService(AdminRepositoryPort adminRepositoryPort) {
        this.adminRepositoryPort = adminRepositoryPort;
    }


    public Admin save(AdminCommand adminCommand) {
        //logic rule check
        if(adminRepositoryPort.existsByUsername(adminCommand.getUsername())) {
            throw new RuntimeException("Username already exists"); //modify global exception UserAlreadyExistException
        }
        //encode password bcrypt
        Admin adminEntityModel = new Admin(
                UUID.randomUUID().toString(),
                adminCommand.getUsername(),
                adminCommand.getPassword()
        );

        Admin savedAdmin = adminRepositoryPort.save(adminEntityModel);
        return savedAdmin;
    }

}
