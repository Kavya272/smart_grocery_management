//package com.smart_grocery.smart_grocery_api.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.smart_grocery.smart_grocery_api.entities.UserEntity;
//import com.smart_grocery.smart_grocery_api.services.UserService;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.regex.Pattern;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    // Get all users with pagination
//    @GetMapping
//    public Page<UserEntity> getAllUsers(@RequestParam(defaultValue = "0") int page,
//                                        @RequestParam(defaultValue = "5") int size) {
//        return userService.getAllUsers(page, size);
//    }
//
//    // Get user by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
//        Optional<UserEntity> user = userService.getUserById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Create user with validation
//    @PostMapping
//    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
//        ResponseEntity<String> validationResponse = validateUser(user);
//        if (validationResponse != null) return validationResponse;
//        
//        return ResponseEntity.ok(userService.createUser(user));
//    }
//
//    // Update user with validation
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserEntity updatedUser) {
//        ResponseEntity<String> validationResponse = validateUser(updatedUser);
//        if (validationResponse != null) return validationResponse;
//        
//        UserEntity updated = userService.updateUser(id, updatedUser);
//        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
//    }
//
//    // Delete user
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
//        if (userService.deleteUser(id)) {
//            return ResponseEntity.ok("User deleted successfully");
//        } else {
//            return ResponseEntity.status(404).body("User not found");
//        }
//    }
//
//    // Validation method for user input
//    private ResponseEntity<String> validateUser(UserEntity user) {
//        // Validate email
//        if (user.getEmail() == null || user.getEmail().isEmpty()) {
//            return ResponseEntity.badRequest().body("Email cannot be empty");
//        }
//        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//        if (!Pattern.matches(emailRegex, user.getEmail())) {
//            return ResponseEntity.badRequest().body("Invalid email format");
//        }
//        if (userService.emailExists(user.getEmail())) {
//            return ResponseEntity.badRequest().body("Email is already in use. Please use a different email");
//        }
//
//        // Validate username
//        if (user.getName() == null || user.getName().isEmpty()) {
//            return ResponseEntity.badRequest().body("Username cannot be empty");
//        }
//        if (user.getName().length() < 3) {
//            return ResponseEntity.badRequest().body("Username must be at least 3 characters long");
//        }
//        String nameRegex = "^[A-Za-z ]+$";
//        if (!Pattern.matches(nameRegex, user.getName())) {
//            return ResponseEntity.badRequest().body("Username can only contain letters and spaces");
//        }
//
//        // Validate password
//        if (user.getPassword() == null || user.getPassword().isEmpty()) {
//            return ResponseEntity.badRequest().body("Password cannot be empty");
//        }
//        if (((CharSequence) user.getPassword()).length() < 8) {
//            return ResponseEntity.badRequest().body("Password must be at least 8 characters long");
//        }
//        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
//        if (!Pattern.matches(passwordRegex, (CharSequence) user.getPassword())) {
//            return ResponseEntity.badRequest().body("Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character");
//        }
//        List<String> weakPasswords = Arrays.asList("password", "123456", "qwerty", "abc123");
//        if (weakPasswords.contains(((String) user.getPassword()).toLowerCase())) {
//            return ResponseEntity.badRequest().body("This password is too common. Please choose a stronger password");
//        }
//
//        return null;
//    }
//}
