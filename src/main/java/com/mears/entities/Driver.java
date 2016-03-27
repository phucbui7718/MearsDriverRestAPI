package com.mears.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="drivers")
@TypeAlias("Driver")
public class Driver {

    @Id
    private String id;
    private String driverNum;
    private String firstName;
    private String lastName;
    private String hireDate;
    private String password;

    public Driver(){

    }

    public Driver (String driverNum, String firstName, String lastName,
                  String hireDate, String password ) {
        this.setDriverNum(driverNum);
        this.setId(driverNum);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setHireDate(hireDate);
        this.setPassword(password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriveNum() {
            return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getDriverFirstName() {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getDriverLastName() {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getDriverNameFirstLast() {
        return firstName + " " + lastName;
    }

    public String getDriverNameLastFirst() {
        return lastName + ", " + firstName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return String.format(
                "Driver: %s %s  Number: %s",
                firstName, lastName, driverNum);
    }

}