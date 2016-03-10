package com.mears.services;

import com.mears.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mears.entities.Driver;


@Component
public class AuthenticationService {

    @Autowired
    DriverRepository driverRepository;

    public boolean isDriverAuthenticated(String driverNum, String password)
    {
        Driver driver = driverRepository.findByDriverNum(driverNum);

        if (driver != null){
            return (driver.getPassword() == password);
        } else {
            return false;
        }
    }


}
