package com.mears.controllers;

import com.mears.entities.DriverRequest;
import com.mears.entities.DriverRequestType;
import com.mears.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {
    @Autowired
    RequestService requestService;

    @RequestMapping(value = "/insert/requests", method = RequestMethod.POST)
    public ResponseEntity<String> insertRequest(@RequestBody DriverRequest driverRequest){

        requestService.insertRequest(driverRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(driverRequest.getId() + " is inserted!");
    }
}
