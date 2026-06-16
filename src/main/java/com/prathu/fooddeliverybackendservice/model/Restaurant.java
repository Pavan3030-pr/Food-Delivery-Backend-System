package com.prathu.fooddeliverybackendservice.model;
 import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Double rating;
    @OneToMany(mappedBy = "restaurant")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<MenuItem> menuItems;
}
