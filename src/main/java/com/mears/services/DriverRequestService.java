package com.mears.services;


import com.mears.entities.DriverRequest;
import com.mears.entities.IdCounter;
import com.mears.repositories.DriverRequestRepository;
import com.mears.repositories.IdCounterRepository;
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
    @Autowired
    private IdCounterRepository idCounterRepository;

    //Insert request
    public String insertRequest(DriverRequest driverRequest){
        IdCounter idCounter = idCounterRepository.findById("DriverRequest");
        driverRequest.setId(idCounter.getNextSequenceValue());
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        String insertMessage;
        try {
            Date reqDate = sd.parse(driverRequest.getRequestDateString().replaceAll("-", "/"));
            Date earliestDate = driverRequest.getRequestType().getEarliestDateToSubmitRequest(reqDate);
            earliestDate = sd.parse(earliestDate.toString());
            Date latestDate = driverRequest.getRequestType().getLatestDateToSubmitRequest(reqDate);
            latestDate = sd.parse(latestDate.toString());
            if (driverRequest.getRequestType().isWithinDateBounds(reqDate)) {
                idCounterRepository.save(idCounter);
                driverRequestRepository.save(driverRequest);
                insertMessage = "Request submitted successfully.";
            } else {
                insertMessage = "Date of request must be between " + latestDate +
                        " and " + earliestDate + ".";
            }
        } catch (ParseException e) {
            insertMessage = "Unable to submit request.";
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
