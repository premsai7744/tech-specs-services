package com.premit.tech_specs_services.repository;

import com.premit.tech_specs_services.entity.DeviceSpecsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceSpecsRepository extends JpaRepository<DeviceSpecsEntity,String> {
}
