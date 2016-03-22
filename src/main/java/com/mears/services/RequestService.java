package com.mears.services;


import com.mears.entities.DriverRequest;
import com.mears.entities.DriverRequestType;
import com.mears.repositories.DriverRequestRepository;
import com.mears.repositories.DriverRequestRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestService {

    static Logger logger = org.slf4j.LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    DriverRequestRepository driverRequestRepository;

    //Insert request.

    public void insertRequest(Long id, String driverNum, DriverRequestType requestType, String requestDate, String reason){

        driverRequestRepository.save(new DriverRequest(id, driverNum, requestType, requestDate, reason));
        logger.info("Driver Request with id " + id + " has been inserted!");
    }


}
