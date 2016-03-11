package com.mears.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.mears.entities.Driver;

public interface DriverRepository extends MongoRepository<Driver, String>{

    Driver findByDriverNum(String driverNum);

}