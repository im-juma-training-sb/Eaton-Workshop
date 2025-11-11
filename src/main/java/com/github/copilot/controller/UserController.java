package com.github.copilot.controller;

import com.github.copilot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    /**
     * Returns a list of sample users.
     *
     * @return ResponseEntity with list of users and HTTP 200 status
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = Arrays.asList(
            new User(1L, "Alice Johnson", "alice@example.com", "admin"),
            new User(2L, "Bob Smith", "bob@example.com", "user"),
            new User(3L, "Charlie Brown", "charlie@example.com", "user"),
            new User(4L, "Diana Prince", "diana@example.com", "user"),
            new User(5L, "Eve Martinez", "eve@example.com", "guest")
        );
        
        return ResponseEntity.ok(users);
    }
}
