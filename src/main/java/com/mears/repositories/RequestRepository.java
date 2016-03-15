package com.mears.repositories;

import com.mears.entities.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.mears.entities.Driver;

public interface RequestRepository extends MongoRepository<Driver, String>{

    @Query("{driverNum : ?0}")
    Request findByDriverNum(String driverNum);

}
