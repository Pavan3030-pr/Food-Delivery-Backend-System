package com.prathu.fooddeliverybackendservice.service;

import com.prathu.fooddeliverybackendservice.model.User;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String registerUser(@NonNull User user){
        return "User registered: "+ user.getName();
    }
}
