package com.github.copilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ========================================
 * STEP 1: Main Application Class
 * ========================================
 * 
 * This is the entry point for our Spring Boot application.
 * 
 * INSTRUCTOR NOTE - LIVE DEMO PROMPT:
 * "Let's ask Copilot Chat: 'What does the @SpringBootApplication annotation do?'"
 * 
 * This demonstrates using Copilot Chat for understanding code and annotations.
 */
@SpringBootApplication
public class CopilotTrainingLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CopilotTrainingLabApplication.class, args);
        System.out.println("🚀 Copilot Training Lab is running!");
        System.out.println("📝 Visit http://localhost:8080/api/hello to test the endpoint");
    }
}
