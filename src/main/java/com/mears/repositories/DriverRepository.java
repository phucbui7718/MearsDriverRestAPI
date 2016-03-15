package com.mears.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.mears.entities.Driver;

import java.util.List;

public interface DriverRepository extends MongoRepository<Driver, String> {

    public Driver findByDriverNum(String driverNum);
    public List<Driver>  findByLastName(String lastName);


}