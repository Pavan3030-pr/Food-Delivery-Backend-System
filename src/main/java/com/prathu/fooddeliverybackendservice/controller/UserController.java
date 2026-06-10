package com.prathu.fooddeliverybackendservice.controller;

import com.prathu.fooddeliverybackendservice.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return "User registered: " + user.getName();
    }
}