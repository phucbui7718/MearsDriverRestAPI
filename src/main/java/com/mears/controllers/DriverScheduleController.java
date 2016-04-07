package com.mears.controllers;

import com.mears.entities.DriverSchedule;
import com.mears.services.DriverScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DriverScheduleController {

    @Autowired
    DriverScheduleService driverScheduleService;

    @RequestMapping(value = "/get/schedule/{driverNum}", method = RequestMethod.GET)
    public List<DriverSchedule> getDriverSchedules(@PathVariable String driverNum) {
        return driverScheduleService.getDriverSchedules(driverNum);
    }
}
