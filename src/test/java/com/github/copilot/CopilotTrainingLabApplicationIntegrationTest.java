package com.github.copilot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the Copilot Training Lab application.
 * Tests the full application context and end-to-end request/response cycles.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CopilotTrainingLabApplicationIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Should load application context")
    public void contextLoads() {
        assertNotNull(restTemplate);
    }

    @Test
    @DisplayName("Should return hello message from /api/hello endpoint")
    public void shouldReturnHelloMessageFromEndpoint() {
        String url = "http://localhost:" + port + "/api/hello";
        
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Hello from Copilot Training Lab! 🚀", response.getBody().get("message"));
        assertEquals("success", response.getBody().get("status"));
    }

    @Test
    @DisplayName("Should return users list from /api/users endpoint")
    public void shouldReturnUsersListFromEndpoint() {
        String url = "http://localhost:" + port + "/api/users";
        
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(5, response.getBody().length);
    }

    @Test
    @DisplayName("Should return correct content type for JSON responses")
    public void shouldReturnJsonContentType() {
        String url = "http://localhost:" + port + "/api/hello";
        
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getHeaders().getContentType().toString().contains("application/json"));
    }

    @Test
    @DisplayName("Should handle 404 for non-existent endpoints")
    public void shouldReturn404ForNonExistentEndpoints() {
        String url = "http://localhost:" + port + "/api/nonexistent";
        
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
