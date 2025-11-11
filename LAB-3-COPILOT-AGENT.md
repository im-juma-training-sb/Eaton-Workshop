# Lab 3: Copilot Agent

## 🎯 Learning Objectives

By the end of this lab, you will be able to:
- Create GitHub issues for Copilot Agent
- Assign tasks to @copilot
- Review AI-generated pull requests
- Iterate with Copilot Agent on improvements
- Request code reviews from Copilot

**Duration:** 30-40 minutes  
**Level:** ⭐⭐ Intermediate  
**Prerequisites:** Labs 1 & 2 complete, GitHub repository access

---

## 📚 What is Copilot Agent?

Copilot Agent is like having a junior developer on your team. You assign it a GitHub issue, and it:
1. **Analyzes** the requirements
2. **Plans** the implementation
3. **Writes** the code
4. **Creates** tests
5. **Opens** a pull request

All automatically!

---

## 🚀 Prerequisites

### Before You Start
- [ ] Project pushed to GitHub repository
- [ ] Copilot Agent enabled on your repository
- [ ] You have write access to create issues and PRs

### Enable Copilot Agent
1. Go to your repository settings
2. Navigate to "Actions" or "Copilot" settings
3. Ensure Copilot is enabled

---

## 🎓 Exercise 1: Create Your First Issue (15 minutes)

### 1.1 Write a Clear Issue

**Navigate to GitHub:**
1. Go to your repository on GitHub
2. Click "Issues" → "New Issue"
3. Copy this template:

```markdown
**Title:** Add GET /api/users endpoint

**Description:**

## 📝 Feature Request: Users Endpoint

### Objective
Create a new REST endpoint that returns a list of users.

### Requirements
- [ ] Create a `User` model class in `com.github.copilot.model` package with:
  - `Long id`
  - `String name`
  - `String email`
  - `String role` (e.g., "admin", "user", "guest")
  
- [ ] Create a `UserController` in `com.github.copilot.controller` package

- [ ] Add GET endpoint at `/api/users`
  
- [ ] Return a list of 5 sample users

- [ ] Response should be JSON format

- [ ] HTTP Status: 200 OK

### Example Response
\`\`\`json
[
  {
    "id": 1,
    "name": "Alice Johnson",
    "email": "alice@example.com",
    "role": "admin"
  },
  {
    "id": 2,
    "name": "Bob Smith",
    "email": "bob@example.com",
    "role": "user"
  }
]
\`\`\`

### Acceptance Criteria
- Endpoint responds to GET requests at `/api/users`
- Returns valid JSON array
- Returns HTTP 200 status code
- Includes at least 5 sample users

### Technical Notes
- Use `@RestController` annotation
- Follow REST API best practices
- Use appropriate HTTP status codes

@copilot please implement this feature
```

---

### 1.2 Assign to Copilot

After creating the issue:
1. **In the issue comments**, type:
   ```
   @copilot please work on this issue
   ```
2. **Or simply mention:**
   ```
   @copilot
   ```

**What happens next:**
- Copilot analyzes your issue
- It creates an implementation plan
- It writes the code
- It opens a pull request

**Timing:** This usually takes 2-5 minutes.

---

### 1.3 Monitor Copilot's Progress

While Copilot works:
1. You'll see comments showing its progress
2. It might ask clarifying questions
3. It will show you its plan before implementing

**Watch for:**
- ✅ "I'll create the User model..."
- ✅ "I'll add the UserController..."
- ✅ "Opening pull request..."

---

## 🎓 Exercise 2: Review the Pull Request (10 minutes)

### 2.1 Open the PR

Once Copilot creates a PR:
1. Click on the PR link
2. Go to "Files changed" tab
3. Review the code

**Check for:**
- ✅ User model created correctly
- ✅ UserController exists
- ✅ Endpoint path is correct
- ✅ Sample data included
- ✅ Proper annotations used

---

### 2.2 Request a Code Review from Copilot

In the PR comments, type:
```
@copilot review this code for:
- Best practices
- Security issues
- Code quality
- Potential bugs
```

**What Copilot checks:**
- Code style and patterns
- Potential null pointer exceptions
- Security vulnerabilities
- Performance concerns
- Missing error handling

---

### 2.3 Address Feedback

If Copilot suggests changes:

**Option 1: Ask Copilot to fix it**
```
@copilot please apply these suggestions
```

**Option 2: Ask for clarification**
```
@copilot why is [specific issue] a concern?
@copilot how should I fix [problem]?
```

**Option 3: Fix manually**
- Make changes locally
- Push to the PR branch

---

## 🎓 Exercise 3: More Advanced Issues (15 minutes)

### 3.1 Issue: Add Input Validation

Create a new issue:

```markdown
**Title:** Add POST /api/users with input validation

**Description:**

## 🔒 Feature Request: User Creation with Validation

### Objective
Add a POST endpoint for creating users with proper input validation.

### Requirements
- [ ] Add POST endpoint at `/api/users`
- [ ] Accept JSON request body with user details
- [ ] Add validation:
  - `name`: Required, min 2 chars, max 100 chars
  - `email`: Required, valid email format
  - `role`: Required, must be "admin", "user", or "guest"
- [ ] Return HTTP 400 for validation errors with clear error messages
- [ ] Return HTTP 201 for successful creation

### Example Request
\`\`\`json
{
  "name": "Charlie Brown",
  "email": "charlie@example.com",
  "role": "user"
}
\`\`\`

### Example Success Response (201)
\`\`\`json
{
  "id": 6,
  "name": "Charlie Brown",
  "email": "charlie@example.com",
  "role": "user",
  "message": "User created successfully"
}
\`\`\`

### Example Error Response (400)
\`\`\`json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "errors": [
    "email: must be a valid email address",
    "name: size must be between 2 and 100"
  ]
}
\`\`\`

### Technical Notes
- Use `@Valid` annotation
- Use validation annotations: `@NotBlank`, `@Email`, `@Size`
- Create custom validation for role field
- Handle `MethodArgumentNotValidException`

@copilot please implement this
```

---

### 3.2 Issue: Add Exception Handling

```markdown
**Title:** Implement global exception handling

**Description:**

## 🛡️ Feature Request: Centralized Exception Handler

### Objective
Create a global exception handler for consistent error responses.

### Requirements
- [ ] Create `GlobalExceptionHandler` class with `@ControllerAdvice`
- [ ] Handle:
  - `MethodArgumentNotValidException` (400)
  - `ResourceNotFoundException` (404) - create this custom exception
  - `IllegalArgumentException` (400)
  - `Exception` (500)
- [ ] Return consistent error format:

\`\`\`json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/api/users"
}
\`\`\`

### Technical Notes
- Place in `com.github.copilot.exception` package
- Create `ErrorResponse` DTO
- Create custom `ResourceNotFoundException extends RuntimeException`
- Include timestamp, status, error message, and path

@copilot
```

---

### 3.3 Issue: Add Unit Tests

```markdown
**Title:** Add comprehensive unit tests for controllers

**Description:**

## 🧪 Feature Request: Controller Unit Tests

### Objective
Create unit tests for `HelloController` and `UserController`.

### Requirements

**HelloControllerTest:**
- [ ] Test GET `/api/hello` returns 200
- [ ] Test response contains expected JSON fields
- [ ] Test content type is application/json

**UserControllerTest:**
- [ ] Test GET `/api/users` returns 200 and list of users
- [ ] Test POST `/api/users` with valid data returns 201
- [ ] Test POST `/api/users` with invalid data returns 400
- [ ] Test validation error messages

### Technical Notes
- Use `@WebMvcTest` annotation
- Use `MockMvc` for HTTP testing
- Place in `src/test/java/com/github/copilot/controller/`
- Test both success and failure scenarios
- Use descriptive test names

### Example Test
\`\`\`java
@Test
public void shouldReturnUserListWhenGetUsers() throws Exception {
    mockMvc.perform(get("/api/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(5));
}
\`\`\`

@copilot please create these tests
```

---

## 💡 Tips for Working with Copilot Agent

### Writing Effective Issues

**✅ DO:**
- Be specific about requirements
- Include acceptance criteria
- Provide example data
- Mention technical constraints
- Use clear section headings
- Add @copilot mention

**❌ DON'T:**
- Write vague descriptions
- Skip examples
- Forget to mention the tech stack
- Miss important constraints

---

### Good Issue Template

```markdown
**Title:** [Clear, specific title]

## Objective
[What you want to achieve]

## Requirements
- [ ] Specific requirement 1
- [ ] Specific requirement 2

## Example Input/Output
\`\`\`json
{ "example": "data" }
\`\`\`

## Acceptance Criteria
- [What defines success]

## Technical Notes
- [Implementation details]
- [Constraints]

@copilot
```

---

## 🎯 Practice Challenges

### Challenge 1: Create an Issue
Write a GitHub issue for adding a search endpoint:
- GET `/api/users/search?name={name}`
- Returns users matching the name (case-insensitive)
- Returns empty array if no matches

### Challenge 2: Review and Iterate
1. Assign your issue to Copilot
2. Review the PR carefully
3. Request a code review
4. Ask for at least one improvement

### Challenge 3: Fix a Bug
Create an issue reporting a "bug":
- "The /api/hello endpoint should include a timestamp"
- See how Copilot fixes it

---

## ✅ Lab 3 Checklist

By the end of this lab, you should be able to:

- [ ] Write clear, detailed GitHub issues
- [ ] Assign issues to @copilot
- [ ] Monitor Copilot's implementation process
- [ ] Review AI-generated pull requests
- [ ] Request code reviews from Copilot
- [ ] Iterate on Copilot's suggestions
- [ ] Merge or refine AI-generated code

---

## 🎓 Key Takeaways

1. **Copilot Agent automates tasks** - But you still need to review
2. **Clear issues = better results** - Be specific and detailed
3. **Always review PRs** - Don't auto-merge without checking
4. **Use code reviews** - Ask Copilot to review its own code
5. **Iterate** - Work with Copilot to improve solutions
6. **Test everything** - AI-generated code needs testing too

---

## 🚫 Common Mistakes

### Mistake 1: Vague Issues
❌ "Add user feature"  
✅ "Add GET /api/users endpoint returning JSON array of 5 sample users"

### Mistake 2: Auto-Merging
❌ Merge PR without review  
✅ Review code, test locally, then merge

### Mistake 3: Not Using Code Reviews
❌ Skip asking for Copilot's review  
✅ Always request: "@copilot review this code"

### Mistake 4: Giving Up
❌ If first attempt fails, give up  
✅ Refine the issue, try again, or combine with manual coding

---

## 🔄 What's Next?

**Completed Lab 3?** → Continue to **[Lab 4: Copilot Spaces](LAB-4-COPILOT-SPACES.md)**

**Want more practice?** → See **[PRACTICE_ISSUES.md](PRACTICE_ISSUES.md)** for 4 detailed practice issues

**Need help?** → Ask in **[Lab 1: Copilot Chat](LAB-1-COPILOT-CHAT.md)**

---

## 📝 Quick Reference: Issue Patterns

### Feature Request
```markdown
## Objective
[What to build]

## Requirements
- [ ] Requirement 1
- [ ] Requirement 2

## Examples
[Code/JSON examples]

@copilot
```

### Bug Fix
```markdown
## Bug Description
[What's wrong]

## Expected Behavior
[What should happen]

## Actual Behavior
[What's happening]

## Steps to Reproduce
1. Step 1
2. Step 2

@copilot please fix this
```

### Refactoring
```markdown
## Current State
[What exists now]

## Desired State
[What you want]

## Benefits
[Why refactor]

@copilot please refactor
```

---

**Fantastic! You've completed Lab 3! 🎉**

**Next:** **[Lab 4: Copilot Spaces](LAB-4-COPILOT-SPACES.md)** →
