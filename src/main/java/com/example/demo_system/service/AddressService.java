package com.example.demo_system.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_system.entity.Address;
import com.example.demo_system.repository.AddressRepository;
import com.example.demo_system.service.exception.AddressNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService  {

    private final AddressRepository addressRepository;

   public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address not found"));
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address not found"));
        addressRepository.deleteById(id);
    }

    public Address replaceAddress(Long id,Address address) {
        address.setId(id);
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address not found"));
        if (existingAddress != null) {
            
            if (address.getStreet() != null) {
                existingAddress.setStreet(address.getStreet());
            }
            if (address.getCity() != null) {
                existingAddress.setCity(address.getCity());
            }
            return addressRepository.save(existingAddress);
        }
        return null;
    }


}
