package com.premit.tech_specs_services.service;

import com.premit.tech_specs_services.dto.DeviceSpecsDTO;

import java.util.List;

public interface DeviceService {
    public abstract String addDevices(List<DeviceSpecsDTO> deviceSpecsDTOList);
}
