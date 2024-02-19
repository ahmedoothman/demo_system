package com.example.demo_system.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_system.entity.User;
import com.example.demo_system.repository.UserRepository;
import com.example.demo_system.service.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.deleteById(id);
    }

    public User replaceUser(Long id , User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        if (existingUser != null) {
            
            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getRole() != null) {
                existingUser.setRole(user.getRole());
            }
            return userRepository.save(existingUser);
        }
        return null;
    }

}
