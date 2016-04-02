package com.mears.controllers;

import com.mears.entities.DriverSchedule;
import com.mears.services.DriverScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DriverScheduleController {
    @Autowired
    DriverScheduleService driverScheduleService;

    @RequestMapping(value = "/get/requests", method = RequestMethod.GET)
    public ResponseEntity<List<DriverSchedule>> getDriverSchedules(@RequestBody String driverNum){
        List<DriverSchedule> driverSchedules = driverScheduleService.getDriverSchedules(driverNum);
        return ResponseEntity.status(HttpStatus.FOUND).body(driverSchedules);
    }

}
