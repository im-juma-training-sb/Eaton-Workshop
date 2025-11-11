filepath: Copilot-Spaces-Req.md
# 🚀 Copilot Spaces Custom Instructions - Enterprise Spring Boot Training Lab

## 📋 Project Context & Identity

You are working in a **GitHub Copilot Spaces environment** for an **Enterprise Spring Boot Training Laboratory**. This is a production-grade educational project designed to teach developers how to leverage GitHub Copilot effectively in real-world Spring Boot application development.

### Project Type
- **Domain:** Educational/Training Platform
- **Architecture:** Microservice-ready REST API
- **Maturity:** Production-ready patterns with educational scaffolding
- **Team Size:** Individual developers to small teams (1-5 people)
- **Deployment:** Cloud-native (Kubernetes-ready)

---

## 🏗️ Workspace Architecture

### Current Structure
```
copilot-training-lab/
├── src/
│   ├── main/
│   │   ├── java/com/github/copilot/
│   │   │   ├── CopilotTrainingLabApplication.java
│   │   │   └── controller/
│   │   │       └── HelloController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/github/copilot/controller/
│           └── HelloControllerTest.java
├── pom.xml
├── .github/workflows/build.yml
└── [Documentation: README.md, LAB-*.md, etc.]
```

### Expected Evolution (Production-Ready)
```
copilot-training-lab/
├── src/
│   ├── main/
│   │   ├── java/com/github/copilot/
│   │   │   ├── CopilotTrainingLabApplication.java
│   │   │   ├── config/          # Configuration classes
│   │   │   ├── controller/      # REST endpoints
│   │   │   ├── service/         # Business logic
│   │   │   ├── repository/      # Data access (when JPA added)
│   │   │   ├── model/           # Domain entities & DTOs
│   │   │   ├── exception/       # Custom exceptions & handlers
│   │   │   ├── security/        # Auth & authorization (future)
│   │   │   └── util/            # Utility classes
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       └── static/          # API documentation assets
│   └── test/
│       ├── java/com/github/copilot/
│       │   ├── controller/      # Controller tests
│       │   ├── service/         # Service tests
│       │   └── integration/     # Integration tests
│       └── resources/
│           └── application-test.properties
```

---

## 🎯 Core Development Principles

### 1. Educational First, Production Second
- **Primary Goal:** Teach developers to use Copilot effectively
- **Secondary Goal:** Demonstrate production-quality Spring Boot code
- **Balance:** Include educational comments WITHOUT sacrificing code quality

### 2. Code Quality Standards

#### Mandatory Requirements
- ✅ **No magic strings** - Use constants or enums
- ✅ **Constructor injection** - Never field injection
- ✅ **Input validation** - All `@RequestBody` must use `@Valid`
- ✅ **Proper logging** - SLF4J, never `System.out.println()`
- ✅ **Exception handling** - Centralized with `@ControllerAdvice`
- ✅ **RESTful conventions** - Proper HTTP methods and status codes
- ✅ **Comprehensive tests** - Minimum 80% coverage for new features

#### Optional but Recommended
- 🔹 DTOs for request/response (not domain models directly)
- 🔹 Service layer abstraction (interface + implementation)
- 🔹 Pagination for list endpoints
- 🔹 API versioning (when multiple versions needed)
- 🔹 HATEOAS links (for advanced REST features)

### 3. Spring Boot 3.2.0 Specific Patterns

#### Use Modern Spring Boot Features
```java
// ✅ Records for DTOs (Java 17+)
public record UserResponse(Long id, String name, String email, String role) {}

// ✅ @RestController (not @Controller + @ResponseBody)
@RestController
@RequestMapping("/api/v1")
public class UserController { }

// ✅ ResponseEntity for explicit status control
public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
}

// ✅ Problem Details for errors (RFC 7807)
@ExceptionHandler(ResourceNotFoundException.class)
public ProblemDetail handleNotFound(ResourceNotFoundException ex) {
    return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
}
```

---

## 🛡️ Security & Production Readiness

### Security Checklist (ALWAYS verify)
```java
// Input Validation
@PostMapping("/users")
public ResponseEntity<UserResponse> create(
    @Valid @RequestBody UserRequest request) { // ✅ @Valid present
    // ...
}

// Logging Safety
logger.info("Creating user: {}", request.getName()); // ✅ No sensitive data
// ❌ NEVER: logger.info("Password: {}", password);

// Error Messages
throw new ResourceNotFoundException("User not found"); // ✅ Safe message
// ❌ NEVER: throw new Exception("SQL error: " + rawSqlError);

// SQL Injection Prevention
// ✅ Use Spring Data JPA (parameterized queries)
// ✅ Or use @Query with named parameters
// ❌ NEVER concatenate user input into SQL strings
```

### Production Readiness Checklist
When generating production features, ensure:
- [ ] Comprehensive input validation with meaningful error messages
- [ ] Proper HTTP status codes (200, 201, 400, 404, 500)
- [ ] Consistent error response format across all endpoints
- [ ] Logging at appropriate levels (INFO for business events, DEBUG for details)
- [ ] Unit tests for services, integration tests for controllers
- [ ] API documentation (JavaDoc + endpoint descriptions)
- [ ] Health checks and monitoring considerations

---

## 📝 Code Generation Rules

### 1. REST Endpoint Template

When asked to create a REST endpoint, follow this pattern:

```java
package com.github.copilot.controller;

import com.github.copilot.model.dto.UserRequest;
import com.github.copilot.model.dto.UserResponse;
import com.github.copilot.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing user operations.
 * 
 * <p>This controller demonstrates:
 * <ul>
 *   <li>RESTful API design with proper HTTP methods</li>
 *   <li>Input validation using Bean Validation</li>
 *   <li>Dependency injection with constructor injection</li>
 *   <li>Proper HTTP status code usage</li>
 * </ul>
 * 
 * <p><b>Educational Note:</b> Notice how we separate concerns by delegating
 * business logic to the service layer rather than implementing it directly
 * in the controller. This follows the Single Responsibility Principle.
 * 
 * @see UserService
 * @see UserRequest
 * @see UserResponse
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    /**
     * Constructor injection (recommended over field injection).
     * 
     * @param userService the user service to handle business logic
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     * 
     * <p><b>Educational Note:</b> In production, this should include pagination
     * to avoid loading excessive data. See @PageableDefault annotation.
     * 
     * @return list of all users
     */
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        logger.info("Fetching all users");
        List<UserResponse> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    /**
     * Retrieves a user by ID.
     * 
     * @param id the user ID
     * @return the user details
     * @throws ResourceNotFoundException if user not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        logger.info("Fetching user with id: {}", id);
        UserResponse user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Creates a new user.
     * 
     * <p><b>Educational Note:</b> The @Valid annotation triggers Bean Validation
     * on the UserRequest object. If validation fails, Spring automatically returns
     * HTTP 400 with error details (handled by GlobalExceptionHandler).
     * 
     * @param request the user creation request
     * @return the created user with HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserRequest request) {
        logger.info("Creating new user: {}", request.name());
        UserResponse created = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Updates an existing user.
     * 
     * @param id the user ID to update
     * @param request the updated user data
     * @return the updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request) {
        logger.info("Updating user with id: {}", id);
        UserResponse updated = userService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    /**
     * Deletes a user.
     * 
     * @param id the user ID to delete
     * @return HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        logger.info("Deleting user with id: {}", id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
```

### 2. Model/DTO Template

```java
package com.github.copilot.model.dto;

import jakarta.validation.constraints.*;

/**
 * Request DTO for creating or updating a user.
 * 
 * <p><b>Educational Note:</b> We use a separate DTO (Data Transfer Object)
 * instead of exposing the domain model directly. This provides:
 * <ul>
 *   <li>Flexibility to change internal model without breaking API</li>
 *   <li>Clear API contract documentation</li>
 *   <li>Input validation at API boundary</li>
 *   <li>Security by not exposing internal fields</li>
 * </ul>
 * 
 * <p>Using a Java 17 record makes this immutable and concise.
 * 
 * @param name user's full name (2-100 characters)
 * @param email user's email address (must be valid format)
 * @param role user's role (admin, user, or guest)
 */
public record UserRequest(
    
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name,
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    String email,
    
    @NotNull(message = "Role is required")
    UserRole role
) {}

/**
 * Response DTO for user data.
 * 
 * <p><b>Educational Note:</b> Response DTOs should never include sensitive
 * data like passwords, tokens, or internal IDs that shouldn't be exposed.
 */
public record UserResponse(
    Long id,
    String name,
    String email,
    String role
) {}
```

### 3. Service Layer Template

```java
package com.github.copilot.service;

import com.github.copilot.exception.ResourceNotFoundException;
import com.github.copilot.model.dto.UserRequest;
import com.github.copilot.model.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for user management operations.
 * 
 * <p><b>Educational Note:</b> Using an interface allows for:
 * <ul>
 *   <li>Easy mocking in tests</li>
 *   <li>Multiple implementations (e.g., in-memory vs database)</li>
 *   <li>Clear contract definition</li>
 * </ul>
 */
public interface UserService {
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    UserResponse create(UserRequest request);
    UserResponse update(Long id, UserRequest request);
    void delete(Long id);
}

/**
 * Implementation of UserService with in-memory storage.
 * 
 * <p><b>Educational Note:</b> This implementation uses in-memory storage
 * for simplicity. In production, this would interact with a database
 * through a Repository layer.
 */
@Service
public class UserServiceImpl implements UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final Map<Long, UserResponse> users = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<UserResponse> findAll() {
        logger.debug("Finding all users, count: {}", users.size());
        return new ArrayList<>(users.values());
    }

    @Override
    public UserResponse findById(Long id) {
        logger.debug("Finding user by id: {}", id);
        return users.values().stream()
            .filter(user -> user.id().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(
                "User not found with id: " + id));
    }

    @Override
    public UserResponse create(UserRequest request) {
        logger.info("Creating user: {}", request.name());
        
        // Educational: Check for duplicate email
        boolean emailExists = users.values().stream()
            .anyMatch(user -> user.email().equalsIgnoreCase(request.email()));
        
        if (emailExists) {
            throw new IllegalArgumentException(
                "User with email already exists: " + request.email());
        }
        
        Long id = idGenerator.getAndIncrement();
        UserResponse user = new UserResponse(
            id,
            request.name(),
            request.email(),
            request.role().name()
        );
        
        users.put(id, user);
        logger.info("User created successfully with id: {}", id);
        return user;
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        logger.info("Updating user with id: {}", id);
        
        if (!users.containsKey(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        
        UserResponse updated = new UserResponse(
            id,
            request.name(),
            request.email(),
            request.role().name()
        );
        
        users.put(id, updated);
        logger.info("User updated successfully: {}", id);
        return updated;
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting user with id: {}", id);
        
        UserResponse removed = users.remove(id);
        if (removed == null) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        
        logger.info("User deleted successfully: {}", id);
    }
}
```

### 4. Exception Handling Template

```java
package com.github.copilot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

/**
 * Global exception handler for all controllers.
 * 
 * <p><b>Educational Note:</b> Using @RestControllerAdvice allows us to:
 * <ul>
 *   <li>Centralize error handling logic</li>
 *   <li>Return consistent error responses</li>
 *   <li>Avoid duplicating exception handling in each controller</li>
 *   <li>Implement cross-cutting concerns cleanly</li>
 * </ul>
 * 
 * <p>This uses Spring Boot 3's ProblemDetail (RFC 7807) for standardized
 * error responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles validation errors from @Valid annotations.
     * 
     * <p><b>Educational Note:</b> When Spring finds validation errors,
     * it throws MethodArgumentNotValidException. We catch it here to
     * return a user-friendly error response.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationException(MethodArgumentNotValidException ex) {
        logger.warn("Validation failed: {}", ex.getMessage());
        
        String errors = ex.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.joining(", "));
        
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST,
            "Validation failed: " + errors
        );
        problemDetail.setTitle("Invalid Request");
        problemDetail.setProperty("timestamp", Instant.now());
        
        return problemDetail;
    }

    /**
     * Handles resource not found errors.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFound(ResourceNotFoundException ex) {
        logger.warn("Resource not found: {}", ex.getMessage());
        
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            ex.getMessage()
        );
        problemDetail.setTitle("Resource Not Found");
        problemDetail.setProperty("timestamp", Instant.now());
        
        return problemDetail;
    }

    /**
     * Handles illegal argument errors (business rule violations).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgument(IllegalArgumentException ex) {
        logger.warn("Illegal argument: {}", ex.getMessage());
        
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST,
            ex.getMessage()
        );
        problemDetail.setTitle("Bad Request");
        problemDetail.setProperty("timestamp", Instant.now());
        
        return problemDetail;
    }

    /**
     * Catch-all handler for unexpected errors.
     * 
     * <p><b>Educational Note:</b> In production, this should:
     * <ul>
     *   <li>Log the full stack trace for debugging</li>
     *   <li>Return a generic message to users (don't expose internals)</li>
     *   <li>Alert monitoring systems</li>
     * </ul>
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGenericException(Exception ex) {
        logger.error("Unexpected error occurred", ex);
        
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "An unexpected error occurred. Please contact support."
        );
        problemDetail.setTitle("Internal Server Error");
        problemDetail.setProperty("timestamp", Instant.now());
        
        return problemDetail;
    }
}

/**
 * Custom exception for resource not found scenarios.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```

### 5. Test Template

```java
package com.github.copilot.controller;

import com.github.copilot.model.dto.UserRequest;
import com.github.copilot.model.dto.UserResponse;
import com.github.copilot.model.UserRole;
import com.github.copilot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for UserController.
 * 
 * <p><b>Educational Note:</b> We use @WebMvcTest to:
 * <ul>
 *   <li>Test only the web layer (controllers)</li>
 *   <li>Automatically configure MockMvc</li>
 *   <li>Mock dependencies (services)</li>
 *   <li>Test HTTP request/response handling</li>
 * </ul>
 * 
 * <p>Test naming follows: shouldReturnExpectedResult_WhenGivenCondition
 */
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldReturnAllUsers_WhenGetAllUsersIsCalled() throws Exception {
        // Given: Sample users in the system
        List<UserResponse> users = List.of(
            new UserResponse(1L, "Alice", "alice@example.com", "ADMIN"),
            new UserResponse(2L, "Bob", "bob@example.com", "USER")
        );
        when(userService.findAll()).thenReturn(users);

        // When & Then: GET /api/users returns 200 with user list
        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].name").value("Alice"))
            .andExpect(jsonPath("$[1].name").value("Bob"));

        verify(userService, times(1)).findAll();
    }

    @Test
    void shouldReturnUser_WhenValidIdIsProvided() throws Exception {
        // Given: A user exists with ID 1
        UserResponse user = new UserResponse(1L, "Alice", "alice@example.com", "ADMIN");
        when(userService.findById(1L)).thenReturn(user);

        // When & Then: GET /api/users/1 returns 200 with user details
        mockMvc.perform(get("/api/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Alice"))
            .andExpect(jsonPath("$.email").value("alice@example.com"));
    }

    @Test
    void shouldCreateUser_WhenValidRequestIsProvided() throws Exception {
        // Given: A valid user creation request
        UserResponse created = new UserResponse(3L, "Charlie", "charlie@example.com", "USER");
        when(userService.create(any(UserRequest.class))).thenReturn(created);

        String requestJson = """
            {
                "name": "Charlie",
                "email": "charlie@example.com",
                "role": "USER"
            }
            """;

        // When & Then: POST /api/users returns 201 with created user
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(3))
            .andExpect(jsonPath("$.name").value("Charlie"));

        verify(userService, times(1)).create(any(UserRequest.class));
    }

    @Test
    void shouldReturn400_WhenInvalidEmailIsProvided() throws Exception {
        // Given: A request with invalid email
        String invalidRequest = """
            {
                "name": "Invalid User",
                "email": "not-an-email",
                "role": "USER"
            }
            """;

        // When & Then: POST /api/users returns 400 validation error
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidRequest))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.title").value("Invalid Request"));

        verify(userService, never()).create(any(UserRequest.class));
    }

    @Test
    void shouldReturn400_WhenNameIsTooShort() throws Exception {
        // Given: A request with name too short (< 2 characters)
        String invalidRequest = """
            {
                "name": "A",
                "email": "valid@example.com",
                "role": "USER"
            }
            """;

        // When & Then: Validation should fail
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidRequest))
            .andExpect(status().isBadRequest());
    }
}
```

---

## 🎨 Response Guidelines for Copilot Spaces

### When Asked "Show me all endpoints"
Provide a structured response like:

```markdown
## REST Endpoints in this Project

### Current Endpoints:
1. **GET** `/api/hello`
   - Description: Returns a welcome message
   - Response: `{ "message": "...", "status": "success", "tip": "..." }`
   - Status: 200 OK

### Potential Extensions:
Based on the project structure, you could add:
- **GET** `/api/users` - List all users
- **POST** `/api/users` - Create new user
- **GET** `/api/users/{id}` - Get user by ID
- **PUT** `/api/users/{id}` - Update user
- **DELETE** `/api/users/{id}` - Delete user

Would you like me to implement any of these endpoints?
```

### When Asked "Analyze this project for security"
Provide a comprehensive analysis:

```markdown
## Security Analysis

### ✅ Current Security Posture:
1. **Input Validation:** 
   - ✅ Spring Validation dependency included
   - ⚠️ Not yet implemented on endpoints

2. **Logging:**
   - ✅ Using SLF4J logger configuration
   - ✅ No sensitive data in console logs

3. **Error Handling:**
   - ⚠️ No centralized exception handler yet
   - ⚠️ May expose stack traces to clients

### ❌ Security Gaps:
1. **No Authentication/Authorization**
   - All endpoints are publicly accessible
   - Recommendation: Add Spring Security

2. **No Input Validation**
   - Request bodies not validated
   - Recommendation: Add @Valid and validation constraints

3. **No CORS Configuration**
   - May allow unwanted cross-origin requests
   - Recommendation: Configure CorsConfiguration

4. **No Rate Limiting**
   - Vulnerable to DOS attacks
   - Recommendation: Add Bucket4j or similar

### 🛡️ Recommended Security Enhancements:
1. Add Spring Security with JWT authentication
2. Implement global exception handler
3. Add comprehensive input validation
4. Configure CORS properly
5. Add API rate limiting
6. Implement request logging for audit trail

Would you like me to implement any of these security features?
```

### When Asked "What's missing for production?"
Provide a roadmap:

```markdown
## Production Readiness Checklist

### 🔴 Critical (Must Have):
- [ ] **Authentication & Authorization** - Spring Security + JWT
- [ ] **Database Integration** - Spring Data JPA + PostgreSQL
- [ ] **Exception Handling** - GlobalExceptionHandler
- [ ] **Input Validation** - Bean Validation on all inputs
- [ ] **Logging** - Structured logging with correlation IDs
- [ ] **Health Checks** - Spring Actuator endpoints
- [ ] **Configuration Management** - Environment-specific properties

### 🟡 Important (Should Have):
- [ ] **API Documentation** - SpringDoc OpenAPI (Swagger)
- [ ] **Caching** - Redis for session management
- [ ] **Rate Limiting** - Bucket4j or similar
- [ ] **Monitoring** - Prometheus + Grafana
- [ ] **API Versioning** - /api/v1 structure
- [ ] **Pagination** - For list endpoints
- [ ] **Filtering & Sorting** - Query parameter support

### 🟢 Nice to Have:
- [ ] **HATEOAS** - Hypermedia links in responses
- [ ] **Event Sourcing** - For audit trail
- [ ] **Circuit Breaker** - Resilience4j
- [ ] **Distributed Tracing** - Sleuth + Zipkin
- [ ] **Containerization** - Dockerfile + docker-compose
- [ ] **CI/CD** - Enhanced GitHub Actions workflow

### 📊 Current Implementation:
- ✅ Basic REST API structure
- ✅ Spring Boot 3.2.0
- ✅ Maven build system
- ✅ GitHub Actions CI
- ✅ Basic tests

### 🎯 Recommended Next Steps:
1. **Phase 1:** Add database + exception handling
2. **Phase 2:** Add security + validation
3. **Phase 3:** Add monitoring + documentation
4. **Phase 4:** Add caching + rate limiting

Would you like me to implement any specific feature?
```

---

## 🚨 Error Handling & Validation

### When Generating Code, ALWAYS Include:

1. **Validation annotations on DTOs**
```java
public record UserRequest(
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name,
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    String email
) {}
```

2. **@Valid on controller parameters**
```java
@PostMapping
public ResponseEntity<UserResponse> create(
    @Valid @RequestBody UserRequest request) {
    // ...
}
```

3. **Meaningful exception messages**
```java
throw new ResourceNotFoundException("User not found with id: " + id);
// NOT: throw new Exception("Error");
```

4. **Proper HTTP status codes**
```java
return ResponseEntity.status(HttpStatus.CREATED).body(user); // 201
return ResponseEntity.ok(user);                               // 200
return ResponseEntity.noContent().build();                    // 204
throw new ResourceNotFoundException(...);                     // 404
throw new IllegalArgumentException(...);                      // 400
```

---

## 📚 Documentation Standards

### Educational Comments
Include teaching comments that explain:
- **WHY** a pattern is used (not just WHAT it does)
- **Trade-offs** and alternatives
- **Common pitfalls** to avoid
- **Production considerations**

Example:
```java
/**
 * <p><b>Educational Note:</b> We use constructor injection instead of
 * field injection (@Autowired on fields) because:
 * <ul>
 *   <li>Makes dependencies explicit and required</li>
 *   <li>Easier to test (can pass mocks in constructor)</li>
 *   <li>Immutable dependencies (final fields)</li>
 *   <li>Prevents NullPointerExceptions</li>
 * </ul>
 * 
 * <p>Field injection is considered an anti-pattern in modern Spring.
 */
public UserController(UserService userService) {
    this.userService = userService;
}
```

### JavaDoc Requirements
All public methods and classes must have:
- Brief description
- `@param` for all parameters
- `@return` for return values
- `@throws` for exceptions
- `@see` for related classes
- Educational notes where applicable

---

## 🎯 Workspace-Specific Commands

### Finding Code
When asked to find code, search across ALL files and provide file paths:

```markdown
I found validation implemented in the following locations:

1. **Model Validation:**
   - File: [`UserRequest.java`](src/main/java/com/github/copilot/model/dto/UserRequest.java)
   - Annotations: @NotBlank, @Email, @Size

2. **Controller Validation:**
   - File: [`UserController.java`](src/main/java/com/github/copilot/controller/UserController.java)
   - Usage: @Valid on @RequestBody parameters

3. **Exception Handling:**
   - File: [`GlobalExceptionHandler.java`](src/main/java/com/github/copilot/exception/GlobalExceptionHandler.java)
   - Handles: MethodArgumentNotValidException

Would you like me to show you how to add validation to a specific endpoint?
```

### Generating Related Classes
When asked to generate a service for an existing controller:

```markdown
Based on your existing [`UserController`](src/main/java/com/github/copilot/controller/UserController.java), 
I'll generate a matching UserService.

I see you're using:
- UserRequest and UserResponse DTOs
- CRUD operations (create, read, update, delete)
- RESTful patterns

Here's the service layer implementation...
```

---

## 🧪 Testing Strategy

### Test Coverage Requirements
- **Controllers:** Integration tests with MockMvc
- **Services:** Unit tests with mocked dependencies
- **Validation:** Test both valid and invalid inputs
- **Edge Cases:** Null values, empty strings, boundary conditions

### Test Naming Convention
```java
// Pattern: shouldReturnExpectedResult_WhenGivenCondition

@Test
void shouldReturnUser_WhenValidIdIsProvided() { }

@Test
void shouldThrowException_WhenUserNotFound() { }

@Test
void shouldReturn400_WhenEmailIsInvalid() { }
```

---

## 🚀 Quick Reference for Common Requests

### "Generate a complete CRUD for Product"
1. Create `Product.java` model with validation
2. Create `ProductRequest` and `ProductResponse` DTOs
3. Create `ProductService` interface and implementation
4. Create `ProductController` with all CRUD endpoints
5. Create `ProductControllerTest` with comprehensive tests
6. Update documentation

### "Add authentication"
1. Add Spring Security dependency to pom.xml
2. Create `SecurityConfig.java`
3. Create `JwtTokenProvider.java`
4. Create `AuthenticationController.java`
5. Add JWT filter
6. Update existing controllers with @PreAuthorize
7. Create authentication tests

### "Improve error handling"
Enhance [`GlobalExceptionHandler`](src/main/java/com/github/copilot/exception/GlobalExceptionHandler.java) with:
- More specific exception types
- Better error messages
- Correlation IDs for tracking
- Structured logging

---

## ✅ Final Checklist for Every Generated Feature

Before presenting code, verify:
- [ ] Follows Spring Boot 3.2.0 conventions
- [ ] Uses Java 17 features (records, text blocks)
- [ ] Has comprehensive input validation
- [ ] Includes proper exception handling
- [ ] Uses constructor injection (not field injection)
- [ ] Has SLF4J logging (not System.out)
- [ ] Returns appropriate HTTP status codes
- [ ] Includes JavaDoc with educational notes
- [ ] Has comprehensive unit/integration tests
- [ ] Follows RESTful API design
- [ ] No magic strings or numbers
- [ ] No security vulnerabilities
- [ ] Includes links to related files in workspace

---

## 🎓 Remember: Education + Production Quality

This project serves two masters:
1. **Teaching developers** how to use Copilot effectively
2. **Demonstrating** production-quality Spring Boot code

Never sacrifice code quality for simplicity, but always explain WHY you're doing something the "right way" versus the "easy way."

---

**Use these instructions to maintain consistency, quality, and educational value across all code generation and analysis in Copilot Spaces.**