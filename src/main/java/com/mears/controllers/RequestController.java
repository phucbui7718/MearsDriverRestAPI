package com.mears.controllers;

import com.mears.entities.DriverRequest;
import com.mears.entities.DriverRequestType;
import com.mears.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @Autowired
    RequestService requestService;

    @RequestMapping(value = "/insert/requests/{request_id}/{driver_num}/{driverRequestType}/{requestDate}/{reason}", method = RequestMethod.POST)
    public ResponseEntity<String> insertRequest(@PathVariable("request_id") long request_id,
                                                @PathVariable("driver_num") String driver_num,
                                                @PathVariable("driverRequestType")DriverRequestType driverRequestType,
                                                @PathVariable("requestDate") String requestDate,
                                                @PathVariable("reason") String reason) {

        requestService.insertRequest(request_id, driver_num, driverRequestType, requestDate,reason);


        return ResponseEntity.status(HttpStatus.OK).body("Request with ID " + request_id + " is inserted.");
    }
}
