package com.mears.repositories;

import java.util.List;
import com.mears.entities.DriverSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverScheduleRepository extends MongoRepository<DriverSchedule, String>{

    @Query("{driverNum : ?0}")
    List<DriverSchedule> findByDriverNum(String driverNum);
}
