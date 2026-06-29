package com.premit.tech_specs_services.service;

import com.premit.tech_specs_services.dto.DeviceSpecsDTO;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    public abstract String addDevices(List<DeviceSpecsDTO> deviceSpecsDTOList);
    public abstract List<DeviceSpecsDTO> getAllDevices();
    public abstract DeviceSpecsDTO getDeviceById(String id);
    public abstract DeviceSpecsDTO getDeviceByName(String name);
    public abstract List<DeviceSpecsDTO> getDeviceByFilters(Map<String,String> values);
}
