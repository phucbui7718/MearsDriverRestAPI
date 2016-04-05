package com.mears.entities;

import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection="driverRequests")
@TypeAlias("DriverRequest")
public class DriverRequest {

    @Id
    private long id;
    private String driverNum;
    private DriverRequestType requestType;
    private String requestDate;
    private String reason;

    public DriverRequest(long id, String driverNum, DriverRequestType requestType,
                         String requestDate, String reason) {
        this.setId(id);
        this.setDriverNum(driverNum);
        this.setRequestType(requestType);
        this.setRequestDate(requestDate);
        this.setReason(reason);
    }

    public DriverRequest(String driverNum, DriverRequestType requestType,
                         String requestDate, String reason) {
        this.setId(0);
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

    public String getRequestDateString() {
        return requestDate;
    }

    public String getFormattedRequestDateString() {
        return requestDate.replace("-", "/");
    }

    public Date getRequestDate() {
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
        this.requestDate = requestDate.replace("/", "-");
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String toString() {
        return String.format("DriverNum: %s \nDate: %s \nType: %s \nReason: %s",
                this.getDriverNum(), this.getFormattedRequestDateString(),
                this.getRequestType().getDescription(), this.getReason());
    }

}
