package com.mears.entities;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.data.annotation.Id;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="driverSchedules")
@TypeAlias("DriverSchedule")
public class DriverSchedule {

    @Id
    private long id;
    private String driverNum;
    private String scheduleDate;
    private String startTime;
    private String endTime;

    public DriverSchedule() {}

    public DriverSchedule(long id, String driverNum, String scheduleDate,
                          String startTime, String endTime) {
        this.setId(id);
        this.setDriverNum(driverNum);
        this.setScheduleDate(scheduleDate);
        this.setStartTime(startTime);
        this.setEndTime(endTime);

    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public Date toDate() {
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String tempDate = this.scheduleDate.replaceAll("-", "/");
            return df.parse(tempDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return null;
        }
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String toString() {
        return String.format("Date: %s \nShift: %s - %s",
                scheduleDate, startTime, endTime);
    }
}
