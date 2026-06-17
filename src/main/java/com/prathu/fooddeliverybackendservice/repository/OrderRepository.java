package com.prathu.fooddeliverybackendservice.repository;

import com.prathu.fooddeliverybackendservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}