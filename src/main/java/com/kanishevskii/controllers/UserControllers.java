package com.kanishevskii.controllers;

import com.kanishevskii.domain.User;
import com.kanishevskii.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControllers {

    private final IUserService userService;

    @Autowired
    public UserControllers(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/create_table")
    public ResponseEntity<String> getTest() {
        userService.createTableUser();
        return new ResponseEntity<>("Table has been created", HttpStatus.OK);
    }

    @PostMapping(path = "/user/create")
    public ResponseEntity<Integer> createUser(@RequestBody User user) {
        int result = userService.createUser(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(path = "/user/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User result = userService.getUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping(path = "/user/delete/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable long id) {
        int result = userService.deleteUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

