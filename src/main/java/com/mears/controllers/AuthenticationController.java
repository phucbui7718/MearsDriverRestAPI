package com.mears.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mears.services.AuthenticationService;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
public class AuthenticationController{

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/authenticate/login", method = RequestMethod.PUT)
    public ResponseEntity<String> login(@RequestParam String driverNum, @RequestParam String password){

        if (authenticationService.isDriverAuthenticated(driverNum, password) == true){
            return new ResponseEntity<String>(driverNum  + "is authenticated!", HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }

    // This is used for testing purpose.
    @RequestMapping(value = "/authenticate/{username}/{password}")
   public ResponseEntity<String> getLoginReponse(@PathVariable("username") String username, @PathVariable("password") String password) throws URISyntaxException {


        URI location = null;

        location = new URI("localhost:8080/authenticate"+username+"/"+password);

        if (!username.toString().equals("phucbui") || (!password.toString().equals("group5"))){

            return ResponseEntity.created(location).body(username + " is not authorized!");
        }
        else

        return ResponseEntity.created(location).body(username + " is authorized!");
    }

}
