package com.premit.tech_specs_services.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.premit.tech_specs_services.dto.DeviceSpecsDTO;
import com.premit.tech_specs_services.entity.DeviceSpecsEntity;
import com.premit.tech_specs_services.repository.DeviceSpecsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    DeviceSpecsRepository deviceSpecsRepository;

    @Override
    public String addDevices(List<DeviceSpecsDTO> deviceSpecsDTOList) {
        System.out.println("DeviceServiceImpl.addDevices::Request reached to service::deviceSpecsDTOList:"+deviceSpecsDTOList);

        ObjectMapper objectMapper = new ObjectMapper();

        List<DeviceSpecsEntity> deviceSpecsEntityList = new ArrayList<>();

        deviceSpecsDTOList.stream().forEach(dto->{
            DeviceSpecsEntity deviceSpecsEntity = new DeviceSpecsEntity();
            deviceSpecsEntity.setId(dto.getId());
            deviceSpecsEntity.setName(dto.getName());
            try{
                String jsonData = objectMapper.writeValueAsString(dto.getData());
                deviceSpecsEntity.setData(jsonData);
            } catch (Exception e) {
                e.printStackTrace();
            }
            deviceSpecsEntityList.add(deviceSpecsEntity);
        });
       List<DeviceSpecsEntity> savedDeviceSpecsEntitiesList = deviceSpecsRepository.saveAll(deviceSpecsEntityList);
       if(savedDeviceSpecsEntitiesList!=null){
           return "Devices added successfully.";
       } else {
           return "Devices adding failed.";
       }
    }
}
