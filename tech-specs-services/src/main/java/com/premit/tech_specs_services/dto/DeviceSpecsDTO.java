package com.premit.tech_specs_services.dto;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

@Data
public class DeviceSpecsDTO {
    private String id;
    private String name;
    Map<String,Object> data;
}
