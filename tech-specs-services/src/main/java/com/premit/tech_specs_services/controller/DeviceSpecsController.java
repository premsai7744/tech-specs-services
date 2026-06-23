package com.premit.tech_specs_services.controller;

import com.premit.tech_specs_services.dto.DeviceSpecsDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceSpecsController {

    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public String addDevices(@RequestBody List<DeviceSpecsDTO> deviceSpecsDTOList){
        System.out.println("DeviceSpecsController.addDevices::RequestReceived:"+deviceSpecsDTOList);
        return null;
    }
}
