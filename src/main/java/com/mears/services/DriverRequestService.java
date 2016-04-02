package com.mears.services;


import com.mears.entities.DriverRequest;
import com.mears.repositories.DriverRequestRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class DriverRequestService {

    static Logger logger = org.slf4j.LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    DriverRequestRepository driverRequestRepository;

    //Insert request
    public void insertRequest(DriverRequest driverRequest){

        driverRequestRepository.save(driverRequest);

    }

    //Get list of requests
    public List<DriverRequest> getDriverRequests (String driverNum) {
        List<DriverRequest> driverRequests;
        driverRequests = driverRequestRepository.findByDriverNum(driverNum);
        Collections.sort(driverRequests, new Comparator<DriverRequest>() {
            @Override
            public int compare(DriverRequest o1, DriverRequest o2) {
                return o1.toDate().compareTo(o2.toDate());
            }
        });
        return driverRequests;
    }


}
