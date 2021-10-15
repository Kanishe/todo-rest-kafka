package com.kanishevskii.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {
    @GetMapping("/test")
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("This is our test message", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<String>getGetStatus(){
        return new ResponseEntity<>("200",HttpStatus.OK);
    }
}
