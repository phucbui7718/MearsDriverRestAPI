package com.mears.services;

import com.mears.repositories.DriverRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mears.entities.Driver;


@Component
public class AuthenticationService {

    static Logger logger = org.slf4j.LoggerFactory.getLogger(AuthenticationService.class);
    @Autowired
    DriverRepository driverRepository;

    public boolean isDriverAuthenticated(String driverNum, String password) {

        Driver driver = driverRepository.findByDriverNum(driverNum);

        if (driver != null) {
         if (driver.getPassword().toString().equals(password)){
             logger.info(driverNum + driver.getPassword() + password + "True");
             return true;
         } else
             logger.info(driverNum + driver.getPassword() + password + "False wrong info");
             return false;
        }

        else
            logger.info(driverNum + " is not a valid driver number!");
            logger.info(driverNum + driver.getPassword() + password + "not existed");
            return false;
    }


}
