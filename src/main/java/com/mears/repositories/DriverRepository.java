package com.mears.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.repository.Repository;
import com.mears.entities.Driver;

//import java.util.List;

public interface DriverRepository extends MongoRepository<Driver, String> {

    @Query("{driverNum : ?0}")
    Driver findByDriverNum(String driverNum);
}