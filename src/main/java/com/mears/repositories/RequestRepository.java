package com.mears.repositories;

import java.util.List;
import com.mears.entities.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RequestRepository extends MongoRepository<Request, String>{

    @Query("{driverNum : ?0}")
    List<Request> findByDriverNum(String driverNum);

}
