package com.github.copilot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ========================================
 * STEP 1: Hello Controller
 * ========================================
 * 
 * This is our first REST controller that returns a simple JSON message.
 * 
 * INSTRUCTOR NOTE - LIVE DEMO PROMPTS:
 * 1. Highlight the class and ask Copilot Chat: "Explain this controller"
 * 2. Type a comment: "// Add a GET endpoint that returns the current server time"
 *    and let Copilot suggest the implementation
 * 3. Use Copilot Chat: "How can I test this endpoint?"
 * 
 * This demonstrates:
 * - Using Copilot Chat for code explanations
 * - Using Copilot inline suggestions for new code
 * - Using Copilot Chat for testing guidance
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * Returns a welcome message from the Copilot Training Lab.
     * 
     * INSTRUCTOR TIP: Use Copilot Chat to ask:
     * "What HTTP status code does this method return?"
     */
    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> sayHello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from Copilot Training Lab! 🚀");
        response.put("status", "success");
        response.put("tip", "Try using Copilot Chat to explore this codebase!");
        
        return ResponseEntity.ok(response);
    }

    // LIVE DEMO EXERCISE:
    // Ask students to add a comment here: "// Add endpoint that returns app version"
    // Let Copilot suggest the implementation
    // This shows Copilot's ability to understand context and generate relevant code
}
