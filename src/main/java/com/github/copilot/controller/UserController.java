package com.github.copilot.controller;

import com.github.copilot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * ========================================
 * User Controller
 * ========================================
 * 
 * REST controller for managing user-related endpoints.
 * 
 * This controller demonstrates:
 * - Returning a list of objects as JSON
 * - Using the User model class
 * - Proper REST endpoint structure
 * 
 * INSTRUCTOR NOTE:
 * This is a simple read-only endpoint with hardcoded data.
 * In a real application, this would connect to a database or service.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    /**
     * Returns a list of sample users.
     * 
     * This endpoint demonstrates returning a collection of objects
     * serialized to JSON format.
     *
     * @return ResponseEntity with list of users and HTTP 200 status
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = getSampleUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Provides sample user data for demonstration purposes.
     * 
     * In a production application, this would be replaced with
     * a service call to retrieve data from a database.
     *
     * @return List of sample User objects
     */
    private List<User> getSampleUsers() {
        return Arrays.asList(
            new User(1L, "Alice Johnson", "alice@example.com", "admin"),
            new User(2L, "Bob Smith", "bob@example.com", "user"),
            new User(3L, "Charlie Brown", "charlie@example.com", "user"),
            new User(4L, "Diana Prince", "diana@example.com", "user"),
            new User(5L, "Eve Martinez", "eve@example.com", "guest")
        );
    }
}
