# 🚀 Getting Started - Copilot Training Lab

**Quick setup guide to get started in 5 minutes!**

---

## ✅ Prerequisites Checklist

Before you begin, make sure you have:

- [ ] **Java 17 or higher** installed
  ```bash
  java -version  # Should show version 17+
  ```

- [ ] **Maven 3.6+** installed
  ```bash
  mvn -version  # Should show Maven 3.6+
  ```

- [ ] **Git** installed
  ```bash
  git --version
  ```

- [ ] **GitHub account** created

- [ ] **GitHub Copilot subscription** active

- [ ] **IDE with Copilot extension** installed
  - VS Code + GitHub Copilot extension, OR
  - IntelliJ IDEA + GitHub Copilot plugin

---

## 📥 Step 1: Clone the Repository (2 minutes)

```bash
# Clone the repository
git clone <your-repo-url>

# Navigate to the project
cd copilot-training-lab

# Verify the structure
ls -la
```

**You should see:**
- `pom.xml`
- `src/` folder
- `README.md`
- `.github/` folder
- Documentation files (CONTRIBUTING.md, ISSUES.md, etc.)

---

## 🔧 Step 2: Build the Project (1 minute)

```bash
# Clean and build
mvn clean install
```

**Expected output:**
```
[INFO] BUILD SUCCESS
[INFO] Total time: 15-30 seconds
```

**If you see errors:**
- Verify Java 17 is installed: `java -version`
- Check Maven is working: `mvn -version`
- Ensure you're in the project root directory

---

## ▶️ Step 3: Run the Application (1 minute)

```bash
# Start the Spring Boot application
mvn spring-boot:run
```

**Expected output:**
```
🚀 Copilot Training Lab is running!
📝 Visit http://localhost:8080/api/hello to test the endpoint
```

**In another terminal, test the endpoint:**
```bash
curl http://localhost:8080/api/hello
```

**Expected response:**
```json
{
  "message": "Hello from Copilot Training Lab! 🚀",
  "status": "success",
  "tip": "Try using Copilot Chat to explore this codebase!"
}
```

**Success!** ✅ Your app is running!

Press `Ctrl+C` to stop the application.

---

## 🧪 Step 4: Run Tests (1 minute)

```bash
# Run all tests
mvn test
```

**Expected output:**
```
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 🤖 Step 5: Verify Copilot is Working (1 minute)

### In VS Code:
1. Open the project in VS Code
2. Open `src/main/java/com/github/copilot/controller/HelloController.java`
3. Click the **Copilot icon** in the bottom right (should show "Copilot: Active")
4. Press `Cmd/Ctrl + I` to open Copilot Chat
5. Type: `Explain this controller`
6. If you get a response, **Copilot is working!** ✅

### In IntelliJ IDEA:
1. Open the project in IntelliJ
2. Open `HelloController.java`
3. Right-click → "GitHub Copilot" → "Open Chat"
4. Type: `Explain this controller`
5. If you get a response, **Copilot is working!** ✅

---

## 🎓 What's Next?

Now that everything is set up, choose your learning path:

### 🌟 For Students (Self-Paced):
1. **Read** `README.md` - Comprehensive guide
2. **Try** the exercises in each step
3. **Work through** the 4 issues in `ISSUES.md`
4. **Reference** `QUICK_REFERENCE.md` as needed

**Start here:** Open `README.md` and follow "STEP 1: Project Setup and First Endpoint"

---

### 👨‍🏫 For Instructors (Live Training):
1. **Review** `LIVE_DEMO_GUIDE.md` - Complete session script
2. **Prepare** by running through demos yourself
3. **Test** all Copilot features beforehand
4. **Deliver** the 60-90 minute session

**Start here:** Open `LIVE_DEMO_GUIDE.md` for step-by-step demo instructions

---

### 👥 For Teams (Collaborative):
1. **Fork** the repository for your team
2. **Review** `CONTRIBUTING.md` for workflow
3. **Practice** PR creation and review together
4. **Share** learnings and best practices

**Start here:** Open `CONTRIBUTING.md` for team workflow

---

## 📚 Quick Navigation

| I want to... | Go to... |
|--------------|----------|
| Learn the basics | `README.md` → STEP 1 |
| Practice with issues | `ISSUES.md` |
| Deliver a training | `LIVE_DEMO_GUIDE.md` |
| Look up commands | `QUICK_REFERENCE.md` |
| Submit a PR | `CONTRIBUTING.md` |
| Understand the project | `PROJECT_SUMMARY.md` |

---

## 🆘 Troubleshooting

### Application won't start
```bash
# Check if port 8080 is in use
lsof -i :8080  # macOS/Linux
netstat -ano | findstr :8080  # Windows

# Kill the process or change port in application.properties
```

### Tests are failing
```bash
# Clean and rebuild
mvn clean install

# Run tests with verbose output
mvn test -X
```

### Copilot not suggesting
- **Check:** Copilot icon in IDE (bottom right/status bar)
- **Verify:** Copilot subscription is active
- **Try:** Restart your IDE
- **Ensure:** You're in a supported file type (.java, .md, etc.)

### Maven build errors
```bash
# Update Maven wrapper
mvn wrapper:wrapper

# Clear Maven cache
rm -rf ~/.m2/repository

# Rebuild
mvn clean install
```

---

## 💡 First Steps with Copilot

Once everything is running, try these exercises:

### Exercise 1: Ask Copilot Chat (2 minutes)
1. Open `CopilotTrainingLabApplication.java`
2. Open Copilot Chat (`Cmd/Ctrl + I`)
3. Ask: `"What does this application do?"`
4. Ask: `"How can I add a new endpoint?"`

### Exercise 2: Generate Code (3 minutes)
1. Open `HelloController.java`
2. Add a comment: `// Add GET endpoint that returns the current date and time`
3. Press Enter
4. Watch Copilot suggest the code
5. Press Tab to accept

### Exercise 3: Create Tests (3 minutes)
1. Open `HelloControllerTest.java`
2. Ask Copilot Chat: `"Generate a test for the hello endpoint that checks the message field"`
3. Review the suggestion
4. Add the test

### Exercise 4: Understand the Project (2 minutes)
1. Ask Copilot Chat: `"Explain the project structure"`
2. Ask: `"What technologies are used in this project?"`
3. Ask: `"Show me all endpoints in this application"`

---

## 🎯 Success Criteria

You're ready to start learning when:

- ✅ Application runs without errors
- ✅ All tests pass
- ✅ You can access http://localhost:8080/api/hello
- ✅ Copilot Chat responds to your questions
- ✅ Copilot suggests code when you write comments

---

## 📞 Need Help?

### Check These Resources:
1. **README.md** - Comprehensive documentation
2. **QUICK_REFERENCE.md** - Common commands and prompts
3. **PROJECT_SUMMARY.md** - Project overview
4. **LIVE_DEMO_GUIDE.md** - Troubleshooting section

### Ask Copilot:
```
Open Copilot Chat and ask:
- "I'm getting this error: [paste error], how do I fix it?"
- "How do I start the Spring Boot application?"
- "The tests are failing, what should I check?"
```

### Community Support:
- Create a GitHub issue in this repository
- Ask in your team's Slack/Teams channel
- Consult Spring Boot documentation
- Check Stack Overflow

---

## 🎉 You're All Set!

Congratulations! You're ready to start learning GitHub Copilot.

**Next step:** Open `README.md` and begin with **STEP 1: Project Setup and First Endpoint**

---

**Happy Coding with Copilot! 🚀**

---

## 📊 Quick Reference Card

**Common Commands:**
```bash
# Build
mvn clean install

# Run
mvn spring-boot:run

# Test
mvn test

# Stop app
Ctrl + C
```

**Copilot Shortcuts:**
- Open Chat: `Cmd/Ctrl + I`
- Accept: `Tab`
- Reject: `Esc`

**Test Endpoints:**
```bash
curl http://localhost:8080/api/hello
```

**First Copilot Chat Prompt:**
```
What does this project do and how can I use GitHub Copilot to learn it?
```
