package com.mears.repositories;

import com.mears.entities.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ScheduleRepository extends MongoRepository<Schedule, String>{

    @Query("{driverNum : ?0}")
    Schedule findByDriverNum(String driverNum);
}
