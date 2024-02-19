package com.example.demo_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_system.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
