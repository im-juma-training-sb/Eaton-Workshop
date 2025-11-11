# 🚀 Copilot Training Lab# 🚀 Copilot Training Lab



Welcome to the **GitHub Copilot Training Lab**! Learn to work effectively with GitHub Copilot through hands-on exercises.Welcome to the **Copilot Training Lab** – a hands-on project designed to help developers master GitHub Copilot's features through practical exercises.



---## 📋 Project Overview



## 📚 Training LabsThis is a Spring Boot REST API project that serves as a training ground for learning:

- **GitHub Copilot Chat** - Interactive coding assistance

Complete 5 focused modules, each teaching a specific Copilot feature:- **GitHub Copilot Agents** - Automated task completion

- **GitHub Copilot Spaces** - Collaborative development environments

| Lab | Topic | Duration | Level |- **Copilot Code Reviews** - AI-powered pull request reviews

|-----|-------|----------|-------|

| **[Lab 1](LAB-1-COPILOT-CHAT.md)** | Copilot Chat | 30 min | ⭐ Beginner |## 🛠️ Technologies

| **[Lab 2](LAB-2-INLINE-GENERATION.md)** | Inline Code Generation | 30 min | ⭐ Beginner |

| **[Lab 3](LAB-3-COPILOT-AGENT.md)** | Copilot Agent | 40 min | ⭐⭐ Intermediate |- **Java 17**

| **[Lab 4](LAB-4-COPILOT-SPACES.md)** | Copilot Spaces | 30 min | ⭐⭐ Intermediate |- **Spring Boot 3.2.0**

| **[Lab 5](LAB-5-CODE-REVIEWS.md)** | Code Reviews | 40 min | ⭐⭐ Intermediate |- **Maven** - Build management

- **Spring Web** - REST API development

**Total Time:** 2-3 hours (self-paced) | 90-120 min (instructor-led)- **Spring Boot Test** - Testing framework

- **Spring Validation** - Input validation

---

## 📚 Learning Objectives

## 🚀 Quick Start

By completing this lab, you will learn how to:

```bash

# 1. Navigate to project1. ✅ Use Copilot Chat to understand and explain code

cd copilot-training-lab2. ✅ Generate code with Copilot inline suggestions

3. ✅ Assign issues to Copilot Agent for automated implementation

# 2. Build4. ✅ Work in Copilot Spaces for collaborative development

mvn clean install5. ✅ Request and receive AI-powered code reviews

6. ✅ Write better tests with Copilot assistance

# 3. Run

mvn spring-boot:run## 🎯 Step-by-Step Guide



# 4. Test (in another terminal)### **STEP 1: Project Setup and First Endpoint** ✅

curl http://localhost:8080/api/hello

```**What's included:**

- Maven project with Spring Boot dependencies

**✅ Success?** Start with **[Lab 1: Copilot Chat](LAB-1-COPILOT-CHAT.md)**- Main application class `CopilotTrainingLabApplication.java`

- `HelloController` with `/api/hello` endpoint

**❌ Issues?** See **[GETTING_STARTED.md](GETTING_STARTED.md)**

**Copilot Chat Exercises:**

---1. Open `CopilotTrainingLabApplication.java`

2. Ask Copilot Chat: *"What does the @SpringBootApplication annotation do?"*

## 🎯 Learning Paths3. Open `HelloController.java`

4. Highlight the controller and ask: *"Explain this controller"*

### Self-Paced (2-3 hours)5. Ask: *"How can I test this endpoint?"*

Complete all labs sequentially at your own pace.

**Try it yourself:**

### Instructor-Led (90-120 min)```bash

Follow **[INSTRUCTOR_GUIDE.md](INSTRUCTOR_GUIDE.md)** for structured sessions.# Build and run the application

mvn spring-boot:run

### Team Workshop (Half-day)

Collaborative learning with hands-on exercises.# Test the endpoint

curl http://localhost:8080/api/hello

---```



## 📖 Additional Resources**Expected Response:**

```json

- **[GETTING_STARTED.md](GETTING_STARTED.md)** - Setup guide{

- **[QUICK_REFERENCE.md](QUICK_REFERENCE.md)** - Copilot commands  "message": "Hello from Copilot Training Lab! 🚀",

- **[INSTRUCTOR_GUIDE.md](INSTRUCTOR_GUIDE.md)** - Teaching materials  "status": "success",

- **[PRACTICE_ISSUES.md](PRACTICE_ISSUES.md)** - Extra exercises  "tip": "Try using Copilot Chat to explore this codebase!"

}

---```



## 🎓 What You'll Learn---



- ✅ Ask questions with Copilot Chat### **STEP 2: Using Copilot Chat for Documentation**

- ✅ Generate code from comments

- ✅ Automate tasks with Copilot Agent**Copilot Chat Exercises:**

- ✅ Collaborate in Copilot Spaces1. Select this README file

- ✅ Conduct AI-powered code reviews2. Ask Copilot Chat: *"Generate API documentation for all endpoints in this project"*

3. Ask: *"What are the best practices for documenting REST APIs?"*

---4. Ask: *"Create a Quick Start guide for developers new to this project"*



**Ready?** → **[Lab 1: Copilot Chat](LAB-1-COPILOT-CHAT.md)** 🚀**Learning Goal:** Understand how Copilot can help with documentation and knowledge transfer.


---

### **STEP 3: Working with Copilot Agent**

**What is Copilot Agent?**
Copilot Agent can autonomously work on GitHub issues by understanding requirements, writing code, and creating pull requests.

**How to use it:**
1. Review the issues in `ISSUES.md`
2. Create a GitHub issue with one of the provided templates
3. Assign the issue to `@copilot`
4. Watch as Copilot Agent:
   - Analyzes the requirements
   - Generates implementation
   - Creates a pull request
   - Adds tests

**Practice Issues Available:**
- 📝 Issue #1: Add `/api/users` endpoint
- 🔒 Issue #2: Add input validation
- 🛡️ Issue #3: Add exception handling
- 🧪 Issue #4: Add unit tests

**Copilot Chat Prompt to Try:**
*"How should I structure the User model for the /api/users endpoint?"*

---

### **STEP 4: Copilot Spaces for Collaboration**

**What is Copilot Spaces?**
A collaborative development environment where you can work alongside Copilot and team members with shared context.

**How to use it:**
1. Open your repository in Copilot Spaces
2. Share the space with team members
3. Use Copilot Chat within the space for team-wide assistance
4. Copilot maintains context across all files and conversations

**Copilot Space Exercise:**
1. Open Copilot Spaces for this repository
2. Ask: *"Show me all REST endpoints in this project"*
3. Ask: *"What's missing from this API that a production app would need?"*
4. Ask: *"Generate a database schema for user management"*

**Learning Goal:** Experience how Copilot maintains context across your entire workspace.

---

### **STEP 5: Code Reviews with Copilot**

**How to request a Copilot code review:**
1. Create a pull request
2. In the PR description or comments, mention: `@copilot review`
3. Copilot will analyze your changes and provide:
   - Code quality feedback
   - Security concerns
   - Best practice recommendations
   - Potential bugs
   - Performance suggestions

**Practice Exercise:**
1. Create a new branch: `git checkout -b feature/user-endpoint`
2. Implement one of the issues from `ISSUES.md`
3. Push your branch and create a PR
4. Request: `@copilot review this code for security and best practices`
5. Review Copilot's suggestions

**Copilot Chat Prompts for PR:**
- *"Generate a comprehensive PR description for my changes"*
- *"What should I include in my PR checklist?"*
- *"Review this code for potential security vulnerabilities"*

---

### **STEP 6: Advanced Copilot Features**

**Code Generation:**
1. Type a comment describing what you want: `// Create a REST endpoint that searches users by name`
2. Let Copilot suggest the implementation
3. Use `Tab` to accept suggestions

**Test Generation:**
1. Open a controller class
2. Ask Copilot Chat: *"Generate unit tests for this controller"*
3. Review and accept the suggested tests

**Refactoring:**
1. Highlight a method
2. Ask Copilot Chat: *"How can I refactor this method to be more efficient?"*
3. Ask: *"Apply SOLID principles to this class"*

---

## 🎓 Instructor-Led Demo Flow

### Demo 1: Copilot Chat Basics (5-10 min)
- Show code explanations
- Demonstrate inline suggestions
- Answer "how to" questions

### Demo 2: Copilot Agent (10-15 min)
- Create a GitHub issue
- Assign to @copilot
- Review the generated PR
- Show the automated tests

### Demo 3: Copilot Spaces (5-10 min)
- Open the workspace in Copilot Spaces
- Demonstrate shared context
- Show collaborative features

### Demo 4: Code Reviews (10 min)
- Create a sample PR
- Request Copilot review
- Discuss the feedback
- Show PR summary generation

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git
- IDE with GitHub Copilot (VS Code, IntelliJ, etc.)
- GitHub Copilot subscription

### Quick Start

```bash
# Clone the repository
git clone <your-repo-url>
cd copilot-training-lab

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# Run tests
mvn test
```

### Verify Installation
```bash
curl http://localhost:8080/api/hello
```

---

## 📖 Additional Resources

### Copilot Documentation
- [GitHub Copilot Docs](https://docs.github.com/copilot)
- [Copilot Chat Guide](https://docs.github.com/copilot/github-copilot-chat)
- [Copilot in Pull Requests](https://docs.github.com/copilot/using-github-copilot/code-review)

### Best Practices
- Write clear, descriptive comments to get better suggestions
- Use meaningful variable and function names
- Break complex tasks into smaller steps
- Review and test all Copilot-generated code
- Use Copilot Chat for explanations, not just code generation

---

## 🤝 Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code review process and how to submit pull requests.

---

## 📝 License

This project is for educational purposes.

---

## 💡 Tips for Maximum Learning

1. **Don't just copy-paste** - Understand what Copilot suggests
2. **Experiment** - Try different ways of asking the same question
3. **Review carefully** - Copilot is a tool, not a replacement for thinking
4. **Iterate** - If the first suggestion isn't perfect, refine your prompt
5. **Share insights** - Discuss interesting suggestions with your team

---

## 🎯 Next Steps

After completing this lab:
1. ✅ Apply Copilot features to your own projects
2. ✅ Explore Copilot for CLI and Copilot for Mobile
3. ✅ Share best practices with your team
4. ✅ Set up Copilot for your organization

---

**Happy Coding with Copilot! 🚀**
