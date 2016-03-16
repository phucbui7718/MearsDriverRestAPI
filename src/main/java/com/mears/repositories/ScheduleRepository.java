package com.mears.repositories;

import java.util.List;
import com.mears.entities.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ScheduleRepository extends MongoRepository<Schedule, String>{

    @Query("{driverNum : ?0}")
    List<Schedule> findByDriverNum(String driverNum);
}
