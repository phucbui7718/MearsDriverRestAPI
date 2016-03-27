package com.mears.entities;

import com.mears.repositories.DriverRequestRepository;
import com.mears.repositories.IdCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(collection="driverRequests")
@TypeAlias("DriverRequest")
public class DriverRequest {

    @Id
    private long id;
    private String driverNum;
    private DriverRequestType requestType;
    private String requestDate;
    private String reason;

    @Autowired
    private DriverRequestRepository driverRequestRepository;
    @Autowired
    private IdCounterRepository idCounterRepository;

    public DriverRequest() {}

    public DriverRequest(long id, String driverNum, DriverRequestType requestType,
                         String requestDate, String reason) {
        this.setId(id);
        this.setDriverNum(driverNum);
        this.setRequestType(requestType);
        this.setRequestDate(requestDate);
        this.setReason(reason);
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRequestType(DriverRequestType requestType) {
        this.requestType = requestType;
    }

    public DriverRequestType getRequestType() {
        return requestType;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public Date convertRequestDate() {
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String tempDate = this.requestDate.replaceAll("-", "/");
            return df.parse(tempDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return null;
        }
    }

    public void setRequestDate (String requestDate) {
        this.requestDate = requestDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String toString() {
        return String.format("DriverNum: %s \nDate: %s \nType: %s \nReason: %s",
                driverNum, requestDate, requestType.getDescription(), reason);
    }

    public long getNextSequenceValue() {
        String objectClass = this.getClass().toString().replace("class com.mears.entities.", "");
        long sequenceValue;
        List<IdCounter> idCounter = idCounterRepository.findById(objectClass);
        if (idCounter.get(0).equals(null)) {
            sequenceValue = 1;
        } else {
            sequenceValue = idCounter.get(0).getNextSequenceValue();
        }
        idCounter.get(0).setSequenceValue(sequenceValue);
        idCounterRepository.save(idCounter);
        return sequenceValue;
    }

    public void submitDriverRequest() {
        driverRequestRepository.save(new DriverRequest(this.getId(), this.getDriverNum(),
                this.getRequestType(), this.getRequestDate(), this.getReason()));
    }

}