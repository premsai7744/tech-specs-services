package com.premit.tech_specs_services.repository;

import com.premit.tech_specs_services.dto.DeviceSpecsDTO;
import com.premit.tech_specs_services.entity.DeviceSpecsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceSpecsRepository extends JpaRepository<DeviceSpecsEntity,String>, JpaSpecificationExecutor<DeviceSpecsEntity> {
    public Optional<DeviceSpecsEntity> findByName(String name);
}
