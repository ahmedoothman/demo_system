package com.example.demo_system.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String city;

    @OneToOne(mappedBy = "address" , cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;
}
