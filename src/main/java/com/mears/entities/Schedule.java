package com.mears.entities;

import org.springframework.data.annotation.Id;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="driverSchedules")
@TypeAlias("schedules")
public class Schedule {

    @Id
    private long id;
    private String driverNum;
    private Date scheduleDate;
    private String startTime;
    private String endTime;

    public Schedule() {}

    public Schedule(long id, String driverNum, Date scheduleDate,
                    String startTime, String endTime) {
        this.id = id;
        this.driverNum = driverNum;
        this.scheduleDate = scheduleDate;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
