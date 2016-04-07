package com.mears.services;


import com.mears.entities.DriverRequest;
import com.mears.repositories.DriverRequestRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Component
public class DriverRequestService {

    static Logger logger = org.slf4j.LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private DriverRequestRepository driverRequestRepository;

    //Insert request
    public String insertRequest(DriverRequest driverRequest) {
        SimpleDateFormat df= new SimpleDateFormat("MM/dd/yyyy");
        String insertMessage;
        try {
            Date reqDate = df.parse(driverRequest.getRequestDateString().replaceAll("-", "/"));
            Date earliestDate = driverRequest.getRequestType().getEarliestDateToSubmitRequest(reqDate);
            Date latestDate = driverRequest.getRequestType().getLatestDateToSubmitRequest(reqDate);

            if (driverRequest.getRequestType().isWithinDateBounds(reqDate)) {
                driverRequestRepository.insert(driverRequest);
                insertMessage = "Request submitted successfully.";
            } else {
                insertMessage = "Date of request must be between " + latestDate +
                        " and " + earliestDate + ".";
            }
        } catch (ParseException e) {
            insertMessage = "Unable to submit request / " + e.getMessage();
            logger.info(insertMessage);
        }
        return insertMessage;
    }

    //Get list of requests
    public List<DriverRequest> getDriverRequests (String driverNum) {
        List<DriverRequest> driverRequests;
        driverRequests = driverRequestRepository.findByDriverNum(driverNum);
        Collections.sort(driverRequests, new Comparator<DriverRequest>() {
            @Override
            public int compare(DriverRequest o1, DriverRequest o2) {
                return o1.getRequestDate().compareTo(o2.getRequestDate());
            }
        });
        return driverRequests;
    }
}
