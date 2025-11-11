package com.github.copilot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * ========================================
 * STEP 1: Example Test for HelloController
 * ========================================
 * 
 * This demonstrates basic controller testing with Spring Boot Test.
 * 
 * INSTRUCTOR NOTE - LIVE DEMO PROMPTS:
 * 1. Highlight this test class and ask Copilot Chat: "Explain this test"
 * 2. Ask: "Generate additional test cases for HelloController"
 * 3. Type a comment: "// Add test for GET /api/time endpoint" and let Copilot suggest
 * 
 * This demonstrates:
 * - Using Copilot Chat to understand existing tests
 * - Using Copilot to generate new test cases
 * - Learning testing patterns from Copilot suggestions
 */
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test that the /api/hello endpoint returns HTTP 200 OK status.
     * 
     * INSTRUCTOR TIP: Ask Copilot Chat:
     * "What is MockMvc and why do we use it for testing?"
     */
    @Test
    public void shouldReturnOkStatusForHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk());
    }

    /**
     * Test that the response contains the expected JSON fields.
     * 
     * INSTRUCTOR TIP: Highlight this test and ask Copilot Chat:
     * "How does jsonPath() work in Spring tests?"
     */
    @Test
    public void shouldReturnJsonWithMessageField() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.status").value("success"));
    }

    /**
     * Test that the Content-Type header is application/json.
     * 
     * INSTRUCTOR TIP: Use Copilot Chat to ask:
     * "What other assertions should I add to make this test more comprehensive?"
     */
    @Test
    public void shouldReturnJsonContentType() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    /**
     * Test that the message contains 'Copilot'.
     */
    @Test
    public void shouldReturnMessageContainingCopilot() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello from Copilot Training Lab! 🚀"));
    }

    /**
     * Test that all three response fields are present and have correct values.
     */
    @Test
    public void shouldReturnAllThreeFields() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello from Copilot Training Lab! 🚀"))
                .andExpect(jsonPath("$.status").value("success"))
                .andExpect(jsonPath("$.tip").exists());
    }

    /**
     * Test that the tip field contains expected text.
     */
    @Test
    public void shouldReturnTipFieldWithCopilotText() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tip").value("Try using Copilot Chat to explore this codebase!"));
    }
}
