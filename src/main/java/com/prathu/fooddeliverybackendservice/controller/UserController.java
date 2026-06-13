package com.prathu.fooddeliverybackendservice.controller;

import com.prathu.fooddeliverybackendservice.dto.LoginRequest;
import com.prathu.fooddeliverybackendservice.model.User;
import com.prathu.fooddeliverybackendservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );
    }
}