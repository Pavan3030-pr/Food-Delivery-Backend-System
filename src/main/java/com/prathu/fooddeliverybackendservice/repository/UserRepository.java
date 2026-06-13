package com.prathu.fooddeliverybackendservice.repository;

import com.prathu.fooddeliverybackendservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
