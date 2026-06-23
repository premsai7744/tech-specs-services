package com.premit.tech_specs_services.controller;

import com.premit.tech_specs_services.dto.DeviceSpecsDTO;
import com.premit.tech_specs_services.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceSpecsController {

    @Autowired
    DeviceService deviceService;

    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public String addDevices(@RequestBody List<DeviceSpecsDTO> deviceSpecsDTOList){
        System.out.println("DeviceSpecsController.addDevices::RequestReceived:"+deviceSpecsDTOList);
        String result = deviceService.addDevices(deviceSpecsDTOList);
        return result;
    }

    @GetMapping(path="/objects")
    public List<DeviceSpecsDTO> getAllDevices(){
        List<DeviceSpecsDTO> retrievedDeviceSpecsDTOList = deviceService.getAllDevices();
        return retrievedDeviceSpecsDTOList;
    }

}
