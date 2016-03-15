package com.mears.repositories;

import com.mears.entities.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DriverRepository extends MongoRepository<Driver, String> {

    @Query("{driverNum : ?0}")
    Driver findByDriverNum(String driverNum);
}