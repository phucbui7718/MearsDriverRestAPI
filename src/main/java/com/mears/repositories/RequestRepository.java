package com.mears.repositories;

import com.mears.entities.Request;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;
import com.mears.entities.Driver;

public interface RequestRepository extends Repository<Driver, String>{

    @Query("{driverNum : ?0}")
    Request findByDriverNum(String driverNum);
}
