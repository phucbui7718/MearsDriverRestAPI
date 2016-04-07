package com.mears.controllers;

import com.mears.entities.DriverRequest;
import com.mears.services.DriverRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverRequestController {
    @Autowired
    DriverRequestService driverRequestService;

    @RequestMapping(value = "/insert/requests", method = RequestMethod.POST)
    public ResponseEntity<String> insertDriverRequest(@RequestBody DriverRequest driverRequest){
        driverRequestService.insertRequest(driverRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Request has been submitted!");
    }

    @RequestMapping(value = "/get/requests/{driverNum}", method = RequestMethod.GET)
    public List<DriverRequest> getDriverRequests(@PathVariable("driverNum") String driverNum){
         return driverRequestService.getDriverRequests(driverNum);
    }
}
