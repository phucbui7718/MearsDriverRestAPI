package com.mears.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mears.services.AuthenticationService;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/authenticate")
public class AuthenticationController{

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public ResponseEntity<String> login(@PathVariable String driverNum, @PathVariable String password){

        if (authenticationService.isDriverAuthenticated(driverNum, password) == true){
            return new ResponseEntity<String>(driverNum  + "is authenticated!", HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/{userName}")
    public ModelAndView getUser(@PathVariable("userName") String user){

        ModelAndView model = new ModelAndView("userName Page");
        model.addObject("msg", "hi"+ user);
        return model;
    }

}
