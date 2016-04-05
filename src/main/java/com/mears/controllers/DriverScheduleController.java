package com.mears.controllers;

import com.mears.entities.DriverSchedule;
import com.mears.services.DriverScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DriverScheduleController {

    @Autowired
    DriverScheduleService driverScheduleService;

    @RequestMapping(value = "/get/schedule/{driverNum}", method = RequestMethod.GET)
    public ResponseEntity<String> getDriverSchedules(@PathVariable String driverNum){
        List<DriverSchedule> driverSchedules = driverScheduleService.getDriverSchedules(driverNum);

        if (driverSchedules.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No schedule found for this driver.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(driverSchedules.toString());
    }

}
