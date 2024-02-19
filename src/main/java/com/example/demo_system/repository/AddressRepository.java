package com.example.demo_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_system.entity.Address;
public interface AddressRepository  extends JpaRepository<Address, Long>{

}
