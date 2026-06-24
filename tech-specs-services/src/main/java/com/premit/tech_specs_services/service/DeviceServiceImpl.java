package com.premit.tech_specs_services.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.premit.tech_specs_services.dto.DeviceSpecsDTO;
import com.premit.tech_specs_services.entity.DeviceSpecsEntity;
import com.premit.tech_specs_services.repository.DeviceSpecsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public List<DeviceSpecsDTO> getAllDevices() {

        ObjectMapper objectMapper = new ObjectMapper();

        List<DeviceSpecsDTO> deviceSpecsDTOList = new ArrayList<>();

        List<DeviceSpecsEntity> deviceSpecsEntityList = deviceSpecsRepository.findAll();
        deviceSpecsEntityList.stream().forEach(entity->{
            DeviceSpecsDTO deviceSpecsDTO = new DeviceSpecsDTO();
            deviceSpecsDTO.setId(entity.getId());
            deviceSpecsDTO.setName(entity.getName());
            String json = entity.getData();
            try{
                Map<String,Object> jsonObject = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
                });
                deviceSpecsDTO.setData(jsonObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            deviceSpecsDTOList.add(deviceSpecsDTO);
        });
        return deviceSpecsDTOList;
    }

    @Override
    public DeviceSpecsDTO getDeviceById(String id) {

        DeviceSpecsDTO deviceSpecsDTO = null;

        ObjectMapper objectMapper = new ObjectMapper();

        Optional<DeviceSpecsEntity> optionalDeviceSpecsEntity = deviceSpecsRepository.findById(id);
        if (optionalDeviceSpecsEntity.isPresent()){
           DeviceSpecsEntity deviceSpecsEntity = optionalDeviceSpecsEntity.get();
            deviceSpecsDTO = new DeviceSpecsDTO();
            deviceSpecsDTO.setId(deviceSpecsEntity.getId());
            deviceSpecsDTO.setName(deviceSpecsEntity.getName());
            String json = deviceSpecsEntity.getData();
            try{
                Map<String,Object> parsedMapObject = objectMapper.readValue(json, new TypeReference<Map<String,Object>>() {});
                deviceSpecsDTO.setData(parsedMapObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return deviceSpecsDTO;
        } else {
            return deviceSpecsDTO;
        }

    }
}
