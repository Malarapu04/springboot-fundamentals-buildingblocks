package com.bhavni.restservices.controller;

import com.bhavni.restservices.model.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

    @GetMapping(value="/helloworld")
    public String helloWorld(){

        return "Hello! This is my test Spring boot Rest service";
    }

    @GetMapping(value="/test")
    public String Test(){
        return "Test the get mapping";
    }

    @RequestMapping(method = RequestMethod.GET, path="/userdetails")
    public UserDetails displayUser(){
        return new UserDetails("Bhavni","M","Atlanta");
    }
}
