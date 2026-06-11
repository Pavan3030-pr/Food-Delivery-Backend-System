package com.prathu.fooddeliverybackendservice.service;

import com.prathu.fooddeliverybackendservice.model.User;
import com.prathu.fooddeliverybackendservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        userRepository.save(user);
        return "User saved in DB: " + user.getName();
    }
}