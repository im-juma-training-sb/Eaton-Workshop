package com.github.copilot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for UserController.
 */
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test that the /api/users endpoint returns HTTP 200 OK status.
     */
    @Test
    public void shouldReturnOkStatusForUsersEndpoint() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk());
    }

    /**
     * Test that the response contains a valid JSON array.
     */
    @Test
    public void shouldReturnJsonArray() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }

    /**
     * Test that the response contains 5 users.
     */
    @Test
    public void shouldReturnFiveUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }

    /**
     * Test that each user has the required fields.
     */
    @Test
    public void shouldReturnUsersWithRequiredFields() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].email").exists())
                .andExpect(jsonPath("$[0].role").exists());
    }

    /**
     * Test that the first user matches expected values.
     */
    @Test
    public void shouldReturnCorrectFirstUser() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Alice Johnson"))
                .andExpect(jsonPath("$[0].email").value("alice@example.com"))
                .andExpect(jsonPath("$[0].role").value("admin"));
    }

    /**
     * Test that the second user matches expected values.
     */
    @Test
    public void shouldReturnCorrectSecondUser() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Bob Smith"))
                .andExpect(jsonPath("$[1].email").value("bob@example.com"))
                .andExpect(jsonPath("$[1].role").value("user"));
    }

    /**
     * Test that all users have valid email format.
     */
    @Test
    public void shouldReturnUsersWithValidEmails() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("alice@example.com"))
                .andExpect(jsonPath("$[1].email").value("bob@example.com"))
                .andExpect(jsonPath("$[2].email").value("charlie@example.com"))
                .andExpect(jsonPath("$[3].email").value("diana@example.com"))
                .andExpect(jsonPath("$[4].email").value("eve@example.com"));
    }

    /**
     * Test that the last user has the guest role.
     */
    @Test
    public void shouldReturnLastUserAsGuest() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[4].id").value(5))
                .andExpect(jsonPath("$[4].name").value("Eve Martinez"))
                .andExpect(jsonPath("$[4].role").value("guest"));
    }

    /**
     * Test that all user IDs are unique.
     */
    @Test
    public void shouldReturnUsersWithUniqueIds() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[3].id").value(4))
                .andExpect(jsonPath("$[4].id").value(5));
    }
}
