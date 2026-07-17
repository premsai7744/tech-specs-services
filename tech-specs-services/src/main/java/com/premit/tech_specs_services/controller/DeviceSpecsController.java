package com.premit.tech_specs_services.controller;

import com.premit.tech_specs_services.dto.DeviceSpecsDTO;
import com.premit.tech_specs_services.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DeviceSpecsController {

    @Autowired
    DeviceService deviceService;

    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDevices(@RequestBody List<DeviceSpecsDTO> deviceSpecsDTOList,
                                             @RequestHeader("hostname") String hostName){
        System.out.println("DeviceSpecsController.addDevices::RequestReceived:"+deviceSpecsDTOList);
        System.out.println("HostName is : "+hostName);
        String result = deviceService.addDevices(deviceSpecsDTOList);
        if (result.equalsIgnoreCase("Devices added successfully.")){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="/objects")
    public ResponseEntity<List<DeviceSpecsDTO>> getAllDevices(){
        String token = "asbsbdsfdsfssdfuerfjkhskhdfsssssssssssssss" +
                "sdfffffffffsdrfewfeeeeeedvvvvvsfssfddddddd";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("secret-key",token);
        List<DeviceSpecsDTO> retrievedDeviceSpecsDTOList = deviceService.getAllDevices();
        return new ResponseEntity<>(retrievedDeviceSpecsDTOList,responseHeaders,HttpStatus.OK);
    }

    @GetMapping(path="/device/{id}")
    public DeviceSpecsDTO getDeviceById(@PathVariable String id){
        DeviceSpecsDTO deviceSpecsDTO = deviceService.getDeviceById(id);
        return deviceSpecsDTO;
    }

    @GetMapping(path="/device/name/{name}")
    public DeviceSpecsDTO getDeviceByName(@PathVariable String name) {
        DeviceSpecsDTO deviceSpecsDTO = deviceService.getDeviceByName(name);
        return deviceSpecsDTO;
    }

    @GetMapping(path="/device/filter")
    public List<DeviceSpecsDTO> getDeviceByFilters(@RequestParam Map<String,String> values){
        List<DeviceSpecsDTO> deviceSpecsDTOList = deviceService.getDeviceByFilters(values);
        return deviceSpecsDTOList;
    }
}
