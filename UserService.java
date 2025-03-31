package com.smart_grocery.smart_grocery_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.smart_grocery.smart_grocery_api.entities.UserEntity;
import com.smart_grocery.smart_grocery_api.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users with pagination
    public Page<UserEntity> getAllUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    // Get user by ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create user
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Update user
    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    // Delete user
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
