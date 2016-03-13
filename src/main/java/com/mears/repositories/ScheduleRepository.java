package com.mears.repositories;

import com.mears.entities.Schedule;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;
import com.mears.entities.Driver;

public interface ScheduleRepository extends Repository<Driver, String>{

    @Query("{driverNum : ?0}")
    Schedule findByDriverNum(String driverNum);
}
