# ✅ Todo CLI Application

A powerful, elegant command-line todo list manager built with Java and Maven. Keep track of your tasks, mark them complete, and manage your productivity directly from your terminal!

## 🚀 Features

- **📝 Add Tasks** - Quickly create new todos with a simple command
- **📋 View Active Tasks** - Display all your pending tasks at a glance
- **✓ Mark as Complete** - Archive completed tasks without deleting them
- **🗑️ Delete Tasks** - Permanently remove tasks you no longer need
- **📊 View Completed Tasks** - Review your accomplishments in a separate list
- **💾 Persistent Storage** - All tasks are automatically saved in JSON format
- **👤 User Profiles** - Personalized experience with user registration
- **🔄 Smart Renumbering** - Tasks are automatically renumbered after modifications
- **🎯 Intuitive Interface** - Clean, menu-driven interface for easy navigation
- **🐳 Docker Support** - Run anywhere with Docker containerization
- **🔄 CI/CD Pipeline** - Automated builds and deployments with GitHub Actions

## 🛠️ Tech Stack

- **Java** - Core programming language
- **Maven** - Dependency management and build tool
- **Gson** - JSON serialization/deserialization
- **Docker** - Containerization platform
- **GitHub Actions** - CI/CD automation

## 📋 Prerequisites

### Local Development
- Java 17 or higher
- Maven 3.8+

### Docker Deployment
- Docker Desktop installed
- Docker Hub account (for CI/CD)

## 🔧 Installation & Running

### Option 1: Traditional Java (Local)

1. **Clone the repository**
   ```bash
   git clone https://github.com/NeonWest/ToDoList-CLI.git
   cd ToDoList-CLI
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn exec:java -Dexec.mainClass="com.omar.todo.TodoMain"
   ```

### Option 2: Docker (Recommended)

1. **Clone the repository**
   ```bash
   git clone https://github.com/NeonWest/ToDoList-CLI.git
   cd ToDoList-CLI
   ```

2. **Build and run with Docker**
   ```bash
   docker build -t todo-cli .
   docker run -it --rm -v $(pwd)/data:/app/data todo-cli
   ```

3. **Or use Docker Compose**
   ```bash
   docker-compose up --build
   ```
   Then in another terminal:
   ```bash
   docker attach todo-app
   ```

4. **Pull from Docker Hub** (after CI/CD setup)
   ```bash
   docker pull <your-dockerhub-username>/todo-cli:latest
   docker run -it --rm -v $(pwd)/data:/app/data <your-dockerhub-username>/todo-cli:latest
   ```

### Option 3: Quick Alias (macOS/Linux)

Add to your `~/.zshrc` or `~/.bashrc`:
```bash
alias runtodo="docker run -it --rm -v $(pwd)/data:/app/data todo-cli"
```

Then simply run:
```bash
runtodo
```

## 🎮 Usage

When you launch the application, you'll see an interactive menu:

```
---To Do Cli Application---
Options:
1: Add a new task
2: Show your tasks
3: Delete a task
4: Mark task as complete
5: View completed tasks
6: Quit
```

### Adding a Task
1. Select option `1`
2. Enter your task description
3. Task is automatically numbered and saved

### Viewing Active Tasks
1. Select option `2`
2. All incomplete tasks are displayed with their numbers
3. Completed tasks are hidden from this view

### Deleting a Task
1. Select option `3`
2. Enter the task number you want to delete
3. Task is permanently removed and remaining tasks are renumbered

### Marking Tasks as Complete
1. Select option `4`
2. Enter the task number to mark as done
3. Task is archived but not deleted
4. Task becomes unnumbered and moves to completed list

### Viewing Completed Tasks
1. Select option `5`
2. All completed tasks are displayed with checkmarks
3. These tasks don't show numbers (archived state)

### Exiting
Select option `6` to quit the application

## 📁 Project Structure

```
todo-cli/
├── .github/
│   └── workflows/
│       └── docker-build.yml    # CI/CD pipeline
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── omar/
│                   └── todo/
│                       ├── TodoMain.java       # Main application entry
│                       ├── UserData.java       # User data model
│                       ├── Todoformat.java     # Todo item model
│                       └── JsonEditor.java     # JSON operations
├── data/
│   └── todolist.json           # Data storage (auto-generated)
├── Dockerfile                  # Docker build instructions
├── docker-compose.yml          # Docker Compose configuration
├── .dockerignore              # Docker ignore rules
├── pom.xml                    # Maven configuration
└── README.md
```

## 🐳 Docker Details

### Dockerfile Highlights
- **Multi-stage build** for optimized image size
- Stage 1: Maven build environment
- Stage 2: Lightweight JRE runtime (Alpine-based)
- Persistent data storage via volumes

### Data Persistence
- Todo data is stored in `/app/data/todolist.json` inside the container
- Volume mount `-v $(pwd)/data:/app/data` ensures data persists on your host machine
- Your tasks survive container restarts and removals

## 🔄 CI/CD Pipeline

### Automated Workflow
Every push to `main` or `master` branch triggers:
1. ✅ Code checkout
2. ✅ Java 17 setup
3. ✅ Maven build
4. ✅ Docker image creation
5. ✅ Push to Docker Hub with two tags:
    - `latest` - always points to the newest version
    - `<commit-sha>` - specific version for rollbacks

### Setup CI/CD
1. Fork/clone this repository
2. Create a Docker Hub account
3. Generate Docker Hub access token (Settings → Security → New Access Token)
4. Add secrets to GitHub repository:
    - Go to Settings → Secrets and variables → Actions
    - Add `DOCKER_USERNAME` (your Docker Hub username)
    - Add `DOCKER_PASSWORD` (your Docker Hub access token)
5. Push to trigger the workflow

## 📦 Dependencies

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

## 💡 Example Session

```
---To Do Cli Application---
Please enter your name for registration
> Omar

Options:
1: Add a new task
2: Show your tasks
3: Delete a task
4: Mark task as complete
5: View completed tasks
6: Quit
> 1

Please enter the task:
> Buy groceries
Task added successfully!

> 2
Your Tasks:
1. Buy groceries
2. Finish project
3. Call dentist

> 4
Which task is completed? (ID):
> 2
Task marked as complete!

> 5
Completed Tasks:
✓ Finish project
```

## 🎯 Key Features Explained

### Smart Task Management
- **Active tasks** are numbered sequentially (1, 2, 3...)
- **Completed tasks** become unnumbered (archived state)
- **Automatic renumbering** keeps your list clean after deletions

### Data Persistence
- All tasks are saved to `todolist.json` automatically
- Your data persists between sessions and container restarts
- First-time users are prompted to register their name

### Input Validation
- Invalid inputs are caught and user is prompted to retry
- Task IDs are verified before operations
- Helpful error messages guide the user

### Containerization Benefits
- **Consistency** - Runs the same everywhere
- **Portability** - Share via Docker Hub
- **Isolation** - No dependency conflicts
- **Easy deployment** - One command to run

## 🔮 Future Enhancements

### Application Features
- [ ] Edit existing tasks
- [ ] Task priorities (high, medium, low)
- [ ] Due dates and reminders
- [ ] Categories/tags for organization
- [ ] Search functionality
- [ ] Sort and filter options
- [ ] Export to different formats (CSV, PDF)
- [ ] Undo/redo functionality
- [ ] Recurring tasks

### DevOps Features
- [ ] Unit tests integration
- [ ] Kubernetes deployment manifests
- [ ] Helm charts
- [ ] Multi-architecture Docker builds (ARM64 support)
- [ ] Automated testing in CI pipeline
- [ ] Code coverage reports

## 🤝 Contributing

Contributions are welcome! Feel free to submit issues and pull requests.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 🐛 Troubleshooting

### Docker Issues
- **Container exits immediately**: Ensure you're using `-it` flag for interactive mode
- **Data not persisting**: Check volume mount path is correct
- **Permission errors**: Ensure Docker has access to the data directory

### Build Issues
- **Maven build fails**: Verify Java 17+ is installed
- **Docker build fails**: Check Dockerfile syntax and base image availability

## 📚 Learning Resources

This project demonstrates:
- Java CLI application development
- Maven dependency management
- Docker containerization (multi-stage builds)
- Docker Compose orchestration
- GitHub Actions CI/CD pipelines
- Volume management for data persistence

## 👨‍💻 Author

**Omar Atakishiyev**
- GitHub: [@NeonWest](https://github.com/NeonWest)

---

⭐ If you find this project useful, please consider giving it a star!

*Built with ☕ and Java | Containerized with 🐳*