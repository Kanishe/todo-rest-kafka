package com.kanishevskii.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {
    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }
}
