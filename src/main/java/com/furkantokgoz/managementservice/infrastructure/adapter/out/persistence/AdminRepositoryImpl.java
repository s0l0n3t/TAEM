package com.furkantokgoz.managementservice.infrastructure.adapter.out.persistence;


import com.furkantokgoz.managementservice.infrastructure.adapter.out.persistence.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryImpl extends JpaRepository<AdminEntity, Long> {
    //Only adapter can use this interface
    //Spring data interface extendedJpaRepository.
}
