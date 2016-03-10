package com.mears.repositories;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mears.entities.Driver;

public interface DriverRepository extends MongoRepository<Driver, String>{

    Driver findByDriverNum(String driverNum);

}