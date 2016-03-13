package com.mears.entities;

import org.springframework.data.annotation.Id;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="driverRequests")
@TypeAlias("requests")
public class Request {

    @Id
    private long id;
    private String driverNum;
    private long requestTypeNum;

    private Date requestDate;
    private String reason;

    public Request() {}

    public Request (long id, String driverNum, long requestTypeNum,
                    Date requestDate, String reason) {
        this.setId(id);
        this.setDriverNum(driverNum);
        this.setRequestTypeNum(requestTypeNum);
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

    public void setRequestTypeNum(long requestTypeNum) {
        this.requestTypeNum = requestTypeNum;
    }

    public long getRequestTypeNum() {
        return requestTypeNum;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate (Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
