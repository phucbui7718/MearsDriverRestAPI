package com.mears.services;

import com.mears.entities.DriverSchedule;
import com.mears.repositories.DriverScheduleRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class DriverScheduleService {

    static Logger logger = org.slf4j.LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    DriverScheduleRepository driverScheduleRepository;

    //Get schedule
    public List<DriverSchedule> getDriverSchedules (String driverNum) {
        List<DriverSchedule> driverSchedules;
        driverSchedules = driverScheduleRepository.findByDriverNum(driverNum);
        Collections.sort(driverSchedules, new Comparator<DriverSchedule>() {
            @Override
            public int compare(DriverSchedule o1, DriverSchedule o2) {
                return o1.toDate().compareTo(o2.toDate());
            }
        });
        return driverSchedules;
    }
}
