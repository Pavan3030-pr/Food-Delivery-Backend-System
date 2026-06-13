package com.prathu.fooddeliverybackendservice.service;

import com.prathu.fooddeliverybackendservice.model.User;
import com.prathu.fooddeliverybackendservice.repository.UserRepository;
import com.prathu.fooddeliverybackendservice.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        userRepository.save(user);
        return "User saved in DB: " + user.getName();
    }

    public String loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return "User not found";
        }

        if (user.getPassword().equals(password)) {
            return jwtUtil.generateToken(email);
        }

        return "Invalid Password";
    }
}