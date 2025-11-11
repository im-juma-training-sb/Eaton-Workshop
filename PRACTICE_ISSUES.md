# 💡 Practice Issues

Additional hands-on exercises to reinforce your Copilot skills.

---

## 📚 How to Use These Issues

These are ready-to-use GitHub issue templates for practicing with **Copilot Agent**.

**To use:**
1. Copy an issue template below
2. Create a new GitHub issue in your repository
3. Paste the template
4. Assign to `@copilot`
5. Review the generated PR

---

## Issue #1: Add Users Endpoint

**Reinforces:** Lab 3 (Copilot Agent), Lab 2 (Code Generation)

###Template:
```markdown
**Title:** Add GET /api/users endpoint

## 📝 Feature Request

### Objective
Create a REST endpoint that returns a list of users.

### Requirements
- [ ] Create `User` model in `com.github.copilot.model` package
  - Long id
  - String name
  - String email  
  - String role (admin/user/guest)

- [ ] Create `UserController` in `com.github.copilot.controller`

- [ ] Add GET endpoint at `/api/users`

- [ ] Return 5 sample users as JSON array

- [ ] HTTP status 200 OK

### Example Response
\`\`\`json
[
  {"id": 1, "name": "Alice", "email": "alice@example.com", "role": "admin"},
  {"id": 2, "name": "Bob", "email": "bob@example.com", "role": "user"}
]
\`\`\`

### Acceptance Criteria
- Endpoint responds to GET /api/users
- Returns valid JSON array
- Includes 5 sample users
- Returns HTTP 200

@copilot please implement this
```

---

## Issue #2: Add Input Validation

**Reinforces:** Lab 3 (Copilot Agent), Lab 5 (Code Reviews)

### Template:
```markdown
**Title:** Add POST /api/users with validation

## 🔒 Feature Request

### Objective
Create user creation endpoint with input validation.

### Requirements
- [ ] Add POST endpoint `/api/users`
- [ ] Accept JSON request body
- [ ] Validate:
  - name: required, 2-100 characters
  - email: required, valid format
  - role: required, must be admin/user/guest
- [ ] Return 400 for invalid input
- [ ] Return 201 for success

### Example Request
\`\`\`json
{
  "name": "Charlie",
  "email": "charlie@example.com",
  "role": "user"
}
\`\`\`

### Success Response (201)
\`\`\`json
{
  "id": 6,
  "name": "Charlie",
  "email": "charlie@example.com",
  "role": "user",
  "message": "User created"
}
\`\`\`

### Error Response (400)
\`\`\`json
{
  "errors": [
    "email: must be valid",
    "name: size must be 2-100"
  ]
}
\`\`\`

### Technical Notes
- Use @Valid annotation
- Use @NotBlank, @Email, @Size
- Handle MethodArgumentNotValidException

@copilot
```

---

## Issue #3: Add Exception Handling

**Reinforces:** Lab 3 (Copilot Agent), Lab 5 (Code Reviews)

### Template:
```markdown
**Title:** Implement global exception handler

## 🛡️ Feature Request

### Objective
Centralized exception handling with consistent error responses.

### Requirements
- [ ] Create `GlobalExceptionHandler` with @ControllerAdvice
- [ ] Handle:
  - MethodArgumentNotValidException (400)
  - ResourceNotFoundException (404)
  - IllegalArgumentException (400)
  - Exception (500)
- [ ] Return consistent format:

\`\`\`json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Error details",
  "path": "/api/users"
}
\`\`\`

### Technical Notes
- Create in `com.github.copilot.exception` package
- Create `ErrorResponse` DTO
- Create custom `ResourceNotFoundException`
- Include timestamp, status, message, path

@copilot please implement
```

---

## Issue #4: Add Unit Tests

**Reinforces:** Lab 2 (Code Generation), Lab 5 (Code Reviews)

### Template:
```markdown
**Title:** Add unit tests for controllers

## 🧪 Feature Request

### Objective
Comprehensive controller testing.

### Requirements

**HelloControllerTest:**
- [ ] Test GET /api/hello returns 200
- [ ] Test response contains message field
- [ ] Test content type is application/json

**UserControllerTest:**
- [ ] Test GET /api/users returns 200
- [ ] Test POST /api/users valid data → 201
- [ ] Test POST /api/users invalid data → 400
- [ ] Test validation error messages

### Technical Notes
- Use @WebMvcTest
- Use MockMvc
- Place in src/test/java/com/github/copilot/controller/
- Test success and failure cases

### Example
\`\`\`java
@Test
public void shouldReturnUserList() throws Exception {
    mockMvc.perform(get("/api/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray());
}
\`\`\`

@copilot please create tests
```

---

## Advanced Challenges

### Challenge #5: Add Service Layer

**Objective:** Separate business logic from controllers

```markdown
**Title:** Add UserService layer

## Requirements
- Create UserService interface
- Create UserServiceImpl  
- Add methods: create, findAll, findById, update, delete
- Inject into UserController
- Use in-memory storage (List)

@copilot
```

---

### Challenge #6: Add Search Functionality

**Objective:** Practice query parameters

```markdown
**Title:** Add user search endpoint

## Requirements
- GET /api/users/search?name={name}
- Case-insensitive search
- Returns matching users
- Empty array if no matches

@copilot
```

---

### Challenge #7: Add Pagination

**Objective:** Learn pagination patterns

```markdown
**Title:** Add pagination to /api/users

## Requirements
- Accept page and size query parameters
- Default: page=0, size=10
- Return paginated response with metadata
- Include totalPages, totalElements, currentPage

@copilot
```

---

### Challenge #8: Add API Documentation

**Objective:** Practice documentation

```markdown
**Title:** Add Swagger/OpenAPI documentation

## Requirements
- Add springdoc-openapi dependency
- Configure Swagger UI
- Add @Operation annotations to endpoints
- Add @Schema to models
- Available at /swagger-ui.html

@copilot
```

---

## Self-Guided Exercises

### Exercise Set A: REST API Basics
1. Add DELETE /api/users/{id}
2. Add PUT /api/users/{id}
3. Add GET /api/users/{id}

### Exercise Set B: Validation & Errors
1. Add custom validation annotation
2. Add field-level error messages
3. Add request body validation

### Exercise Set C: Testing
1. Add integration tests
2. Add negative test cases
3. Add edge case tests

### Exercise Set D: Advanced Features
1. Add sorting to /api/users
2. Add filtering by role
3. Add HATEOAS links

---

## Using These for Learning

### Beginner Path
1. Issue #1 - Basic endpoint
2. Issue #4 - Unit tests
3. Challenge #5 - Service layer

### Intermediate Path
1. Issue #2 - Validation
2. Issue #3 - Exception handling
3. Challenge #6 - Search

### Advanced Path
1. Challenge #7 - Pagination
2. Challenge #8 - Documentation
3. Create your own issues!

---

## Tips for Practice

### 1. Start Simple
Begin with Issue #1, then progress to more complex ones.

### 2. Review Carefully
Always review Copilot's generated code:
- Does it compile?
- Does it work?
- Is it secure?
- Is it tested?

### 3. Iterate
If the first implementation isn't perfect:
- Ask Copilot to improve it
- Request a code review
- Refine the requirements

### 4. Learn from Feedback
When Copilot reviews code, understand WHY it suggests changes.

### 5. Combine Skills
Use multiple Copilot features:
- Agent for implementation
- Chat for questions
- Code review for quality
- Spaces for context

---

## Creating Your Own Issues

### Good Issue Template
```markdown
**Title:** [Clear, specific title]

## Objective
[What you want to achieve]

## Requirements
- [ ] Requirement 1
- [ ] Requirement 2

## Examples
\`\`\`
[Code or data examples]
\`\`\`

## Acceptance Criteria
[How to verify success]

## Technical Notes
[Implementation details]

@copilot
```

---

## Track Your Progress

- [ ] Completed Issue #1
- [ ] Completed Issue #2
- [ ] Completed Issue #3
- [ ] Completed Issue #4
- [ ] Completed Challenge #5
- [ ] Completed Challenge #6
- [ ] Completed Challenge #7
- [ ] Completed Challenge #8
- [ ] Created my own issue
- [ ] Helped a teammate

---

## Next Steps

After completing these issues:
1. Apply to real projects
2. Create issues for your actual work
3. Share learnings with your team
4. Contribute to open source

---

**Happy Practicing! 🚀**
