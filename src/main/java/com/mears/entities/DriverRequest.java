package com.mears.entities;

import com.mears.repositories.DriverRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public void submitDriverRequest() {
        driverRequestRepository.save(new DriverRequest(this.getId(), this.getDriverNum(),
                this.getRequestType(), this.getRequestDate(), this.getReason()));
    }

}
