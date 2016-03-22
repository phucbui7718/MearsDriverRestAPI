package com.mears.repositories;

import java.util.List;
import com.mears.entities.DriverRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DriverRequestRepository extends MongoRepository<DriverRequest, String>{

    @Query("{driverNum : ?0}")
    List<DriverRequest> findByDriverNum(String driverNum);

}
