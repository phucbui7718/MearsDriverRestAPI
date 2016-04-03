package com.mears.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mears.services.AuthenticationService;

import java.net.URI;


@RestController
public class AuthenticationController{

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/authenticate/login/{driverNum}/{password}", method = RequestMethod.GET)
    public ResponseEntity<String> login(@PathVariable("driverNum") String driverNum, @PathVariable("password") String password) {


        if (authenticationService.isDriverAuthenticated(driverNum, password)) {
            return ResponseEntity.created(URI.create("localhost:8099/authenticate/login/" + driverNum + "/" + password)).body(driverNum + " is authorized.");
        } else {
           return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Driver Number or Password");
            // return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
    }


}
