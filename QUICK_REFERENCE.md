# 📚 Copilot Quick Reference Guide

Quick reference for common Copilot Chat prompts and commands used in this training lab.

---

## 🗣️ Copilot Chat Prompts

### Understanding Code
```
What does this code do?
Explain the @RestController annotation
How does this method work?
What are the dependencies of this class?
What design patterns are used here?
```

### Generating Code
```
Create a REST endpoint that [description]
Generate a User model with fields: id, name, email
Add validation to this class
Implement error handling for [scenario]
Create a service layer for user management
```

### Testing
```
Generate unit tests for this controller
Create integration tests for the user service
What edge cases should I test?
Write a test that verifies [behavior]
How can I mock this dependency?
```

### Documentation
```
Generate API documentation for all endpoints
Create a Quick Start guide
Write JavaDoc for this class
Document the request/response format
Explain this configuration file
```

### Debugging
```
Why is this code not working?
What's causing this error: [error message]
How can I fix this bug?
Debug this method
What's wrong with this implementation?
```

### Best Practices
```
How can I improve this code?
Apply SOLID principles to this class
Suggest performance improvements
Review this code for security issues
What are Spring Boot best practices for [topic]?
```

### Refactoring
```
Refactor this method to be more readable
Extract this logic into a separate service
Simplify this code
Convert this to use Java streams
How can I make this more maintainable?
```

---

## 🤖 Copilot Agent Commands

### In GitHub Issues
```
@copilot please implement this feature
@copilot work on this issue
@copilot can you help with this?
```

### In Pull Requests
```
@copilot review this PR
@copilot review this code for best practices
@copilot check for security vulnerabilities
@copilot why is this a concern?
@copilot please apply these suggestions
@copilot generate a PR summary
```

---

## ⌨️ Keyboard Shortcuts

### VS Code
- **Open Copilot Chat:** `Cmd/Ctrl + I`
- **Accept suggestion:** `Tab`
- **Reject suggestion:** `Esc`
- **Next suggestion:** `Alt/Option + ]`
- **Previous suggestion:** `Alt/Option + [`
- **Trigger inline suggestion:** `Alt/Option + \`

### IntelliJ IDEA
- **Open Copilot Chat:** `Ctrl + Shift + A` → "GitHub Copilot Chat"
- **Accept suggestion:** `Tab`
- **Reject suggestion:** `Esc`

---

## 💡 Tips for Better Suggestions

### Write Clear Comments
```java
// ✅ GOOD: Add a GET endpoint that returns user details by ID with validation
// ❌ BAD: Add endpoint

// ✅ GOOD: Validate that email is in correct format and not already in use
// ❌ BAD: Validate email
```

### Use Descriptive Names
```java
// ✅ GOOD
public class UserAuthenticationService { ... }

// ❌ BAD
public class UAS { ... }
```

### Provide Context
```java
// Open related files so Copilot understands the context
// For example: Model, Controller, and Service classes
```

### Be Specific
```java
// ✅ GOOD: "Generate unit tests using MockMvc for all endpoints in UserController"
// ❌ BAD: "Generate tests"
```

---

## 🎯 Common Use Cases

### 1. Understanding Existing Code
**Scenario:** You inherited a project and need to understand it.

**Prompts:**
```
Explain the overall architecture of this project
What does this service class do?
How do these classes interact?
Show me all REST endpoints in this project
```

---

### 2. Implementing New Features
**Scenario:** You need to add a new endpoint.

**Steps:**
1. Write a comment: `// Add POST endpoint for user registration with validation`
2. Let Copilot suggest the code
3. Ask: "Generate tests for this endpoint"
4. Ask: "What validation should I add?"

---

### 3. Writing Tests
**Scenario:** You need comprehensive test coverage.

**Prompts:**
```
Generate unit tests for UserController
Create integration tests for the authentication flow
What test cases am I missing?
Add test for edge case: null email input
```

---

### 4. Code Review
**Scenario:** You want feedback on your code.

**In PR comments:**
```
@copilot review this code for:
- Security vulnerabilities
- Performance issues
- Best practices
- Code quality
```

---

### 5. Debugging
**Scenario:** Your code isn't working.

**Prompts:**
```
Why is this method returning null?
Debug this NullPointerException
What's wrong with this SQL query?
How can I fix this validation error?
```

---

## 🚀 Advanced Techniques

### Multi-line Suggestions
1. Write a descriptive comment
2. Press `Enter` and wait
3. Copilot suggests multiple lines
4. Press `Tab` to accept

### Iterative Refinement
1. If suggestion isn't perfect, reject it (`Esc`)
2. Refine your comment
3. Request suggestion again
4. Or ask Copilot Chat to explain why it suggested that

### Context Window
- Keep related files open in tabs
- Copilot uses context from open files
- This improves suggestion quality

### Learning from Suggestions
1. Accept a suggestion
2. Ask Copilot Chat: "Why did you suggest this approach?"
3. Learn the reasoning and patterns

---

## 📊 Copilot Capabilities Matrix

| Task | Copilot Chat | Inline | Agent | Spaces |
|------|-------------|--------|-------|--------|
| Explain code | ✅ | ❌ | ❌ | ✅ |
| Generate code | ✅ | ✅ | ✅ | ✅ |
| Write tests | ✅ | ✅ | ✅ | ✅ |
| Debug errors | ✅ | ❌ | ❌ | ✅ |
| Code review | ✅ | ❌ | ✅ | ✅ |
| Create PRs | ❌ | ❌ | ✅ | ❌ |
| Refactor | ✅ | ✅ | ✅ | ✅ |
| Document | ✅ | ✅ | ✅ | ✅ |

---

## ⚠️ Important Reminders

### Always Review Code
- ✅ **DO:** Read and understand all suggestions
- ❌ **DON'T:** Blindly accept without review

### Test Everything
- ✅ **DO:** Test Copilot-generated code
- ❌ **DON'T:** Assume it's bug-free

### Security First
- ✅ **DO:** Review security-sensitive code carefully
- ❌ **DON'T:** Use Copilot for authentication/encryption without expert review

### Learn, Don't Copy
- ✅ **DO:** Ask Copilot to explain concepts
- ❌ **DON'T:** Skip learning fundamentals

### Iterate and Refine
- ✅ **DO:** Refine prompts if first suggestion isn't perfect
- ❌ **DON'T:** Give up after one attempt

---

## 🎓 Practice Exercises

### Beginner
1. Ask Copilot to explain the `@SpringBootApplication` annotation
2. Generate a simple GET endpoint
3. Create a basic model class

### Intermediate
1. Implement a full CRUD controller
2. Add input validation
3. Generate comprehensive tests

### Advanced
1. Create a service layer with business logic
2. Implement custom exception handling
3. Add integration tests with database

---

## 📖 Additional Resources

- [GitHub Copilot Documentation](https://docs.github.com/copilot)
- [Copilot Best Practices](https://docs.github.com/copilot/using-github-copilot/best-practices)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Java 17 Features](https://openjdk.org/projects/jdk/17/)

---

## 💬 Need Help?

**Ask Copilot Chat:**
```
How do I [task]?
What's the best practice for [scenario]?
I'm stuck with [problem], can you help?
```

**Or check:**
- README.md - Project overview
- CONTRIBUTING.md - Development workflow
- ISSUES.md - Practice exercises
- LIVE_DEMO_GUIDE.md - Instructor notes

---

**Happy Coding with Copilot! 🚀**
