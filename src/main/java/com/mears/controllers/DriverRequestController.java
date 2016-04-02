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
        return ResponseEntity.status(HttpStatus.CREATED).body("Request " +
                driverRequest.getId() + " has been submitted!");
    }

    @RequestMapping(value = "/get/requests", method = RequestMethod.GET)
    public ResponseEntity<List<DriverRequest>> getDriverRequests(@RequestBody String driverNum){
        List<DriverRequest> driverRequests = driverRequestService.getDriverRequests(driverNum);
/*
        String responseMessage;
        if (driverRequests.size() == 1) {
            responseMessage = driverRequests.size() + " request has been found";
        } else {
            responseMessage = driverRequests.size() + " requests have been found";
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(responseMessage);
*/
        return ResponseEntity.status(HttpStatus.FOUND).body(driverRequests);
    }
}
