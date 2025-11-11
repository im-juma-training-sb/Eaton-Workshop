# Lab 1: Copilot Chat

## 🎯 Learning Objectives

By the end of this lab, you will be able to:
- Ask Copilot Chat questions about code
- Get explanations of frameworks and patterns
- Request debugging and testing help
- Generate documentation with AI assistance

**Duration:** 20-30 minutes  
**Level:** ⭐ Beginner  
**Prerequisites:** Project setup complete

---

## 📚 What is Copilot Chat?

Copilot Chat is your AI pair programmer that you can ask questions. Think of it as having an expert developer next to you who can:
- Explain code and concepts
- Answer "how-to" questions
- Help debug issues
- Suggest improvements
- Generate documentation

---

## 🚀 Getting Started

### Open Copilot Chat

**VS Code:**
- Press `Cmd/Ctrl + I` or
- Click the chat icon in the sidebar

**IntelliJ IDEA:**
- Right-click → "GitHub Copilot" → "Open Chat"

**Verify it's working:**
Type: `Hello, are you working?`

---

## 🎓 Exercise 1: Understanding Code (10 minutes)

### 1.1 Explain an Annotation

1. Open `src/main/java/com/github/copilot/CopilotTrainingLabApplication.java`
2. In Copilot Chat, ask:
   ```
   What does the @SpringBootApplication annotation do?
   ```

**What to observe:**
- Copilot explains the annotation's purpose
- It mentions what features it enables
- It might suggest when to use it

**Try also:**
```
What are the alternatives to @SpringBootApplication?
How does Spring Boot auto-configuration work?
```

---

### 1.2 Explain a Controller

1. Open `src/main/java/com/github/copilot/controller/HelloController.java`
2. **Highlight the entire `sayHello()` method**
3. In Copilot Chat, ask:
   ```
   Explain this controller method
   ```

**What to observe:**
- Copilot describes what the endpoint does
- It explains the HTTP method (GET)
- It describes the response format
- It mentions status codes

**Try also:**
```
What HTTP status codes can this method return?
How would I add error handling to this method?
What's the difference between @RestController and @Controller?
```

---

### 1.3 Understanding the Project Structure

Ask Copilot Chat:
```
Explain the project structure of this Spring Boot application
```

**What to observe:**
- Copilot lists the main directories
- It explains the purpose of each folder
- It might suggest improvements

**Follow-up questions:**
```
What files are required for a Spring Boot project?
Where should I put configuration files?
What's the purpose of the test directory?
```

---

## 🎓 Exercise 2: Getting Help (10 minutes)

### 2.1 Testing Guidance

With `HelloController.java` open, ask:
```
How can I test this endpoint?
```

**What to observe:**
- Copilot suggests multiple testing approaches
- It might mention `curl`, Postman, or unit tests
- It could provide example code

**Try it:**
```bash
# If Copilot suggests curl:
curl http://localhost:8080/api/hello

# Or if it suggests httpie:
http http://localhost:8080/api/hello
```

---

### 2.2 Understanding Dependencies

Open `pom.xml` and ask:
```
What dependencies are included in this project?
```

**Follow-up:**
```
Why do we need spring-boot-starter-web?
What does spring-boot-starter-test provide?
Should I add any other dependencies for a production app?
```

---

### 2.3 Debugging Help

Ask Copilot Chat:
```
I'm getting a 404 error when I try to access /api/hello. What could be wrong?
```

**What to observe:**
- Copilot suggests common causes
- It asks clarifying questions
- It provides troubleshooting steps

---

## 🎓 Exercise 3: Learning New Concepts (5 minutes)

### 3.1 Framework Questions

Ask Copilot:
```
What is Spring Boot and why would I use it?
```

**Then ask:**
```
What's the difference between Spring and Spring Boot?
What are the main features of Spring Boot?
```

---

### 3.2 Best Practices

Ask:
```
What are Spring Boot best practices for REST API development?
```

**Follow-up:**
```
How should I structure a Spring Boot project?
What security considerations should I be aware of?
```

---

## 🎓 Exercise 4: Documentation Generation (5 minutes)

### 4.1 Generate JavaDoc

Highlight the `HelloController` class and ask:
```
Generate JavaDoc documentation for this class
```

**What to observe:**
- Copilot generates documentation comments
- It describes parameters and return values
- It might add usage examples

---

### 4.2 API Documentation

Ask:
```
Generate API documentation for all endpoints in this project
```

**What you get:**
- List of all endpoints
- HTTP methods
- Request/response formats
- Example usage

---

## 💡 Tips for Effective Copilot Chat Usage

### Write Clear Questions
✅ **GOOD:** "How do I add input validation to this REST endpoint?"  
❌ **BAD:** "validation"

### Be Specific
✅ **GOOD:** "Explain why this method returns ResponseEntity instead of a plain object"  
❌ **BAD:** "why ResponseEntity?"

### Provide Context
✅ **GOOD:** "I'm building a REST API with Spring Boot. How should I handle exceptions?"  
❌ **BAD:** "How to handle exceptions?"

### Iterate
If the first answer isn't perfect:
- Ask for clarification
- Rephrase your question
- Ask follow-up questions

---

## 🎯 Practice Challenges

### Challenge 1: Explore the Codebase
Ask Copilot to:
1. List all REST endpoints in the project
2. Explain the application's architecture
3. Suggest improvements

### Challenge 2: Learn Testing
Ask about:
1. How to write unit tests for controllers
2. What MockMvc does
3. How to test REST APIs

### Challenge 3: Understand Spring Boot
Ask:
1. How Spring Boot auto-configuration works
2. What the application.properties file does
3. How to configure different environments

---

## ✅ Lab 1 Checklist

By the end of this lab, you should be able to:

- [ ] Open Copilot Chat in your IDE
- [ ] Ask questions about code and get explanations
- [ ] Understand annotations and frameworks
- [ ] Get testing and debugging help
- [ ] Generate documentation
- [ ] Write effective questions for Copilot

---

## 🎓 Key Takeaways

1. **Copilot Chat is a learning tool** - Use it to understand unfamiliar code
2. **Ask specific questions** - Clear questions get better answers
3. **Iterate and refine** - Follow up for clarification
4. **Verify the answers** - Always test and validate suggestions
5. **Use it for documentation** - Great for generating docs and explanations

---

## 🔄 What's Next?

**Completed Lab 1?** → Continue to **[Lab 2: Inline Code Generation](LAB-2-INLINE-GENERATION.md)**

**Need more practice?** → See **[PRACTICE_ISSUES.md](PRACTICE_ISSUES.md)** for additional exercises

**Quick lookup?** → Check **[QUICK_REFERENCE.md](QUICK_REFERENCE.md)** for common prompts

---

## 📝 Common Copilot Chat Prompts

### Understanding Code
```
What does this code do?
Explain this class/method
How does this work?
What design patterns are used here?
```

### Getting Help
```
How can I test this?
What's wrong with this code?
How do I fix this error: [error message]
What are best practices for [topic]?
```

### Learning
```
What is [concept]?
How does [framework/library] work?
What's the difference between X and Y?
Show me an example of [pattern]
```

### Documentation
```
Generate documentation for this code
Create JavaDoc comments
Document the API endpoints
Explain the parameters and return values
```

---

**Great job! You've completed Lab 1! 🎉**

**Next:** **[Lab 2: Inline Code Generation](LAB-2-INLINE-GENERATION.md)** →
