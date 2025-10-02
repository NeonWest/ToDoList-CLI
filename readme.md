# ✅ Todo CLI Application

A simple, elegant command-line todo list manager built with Java and Maven. Keep track of your tasks directly from your terminal!

## 🚀 Features

- **📝 Add Tasks** - Quickly add new todos with a simple command
- **📋 View Tasks** - Display all your pending tasks at a glance
- **💾 Persistent Storage** - All tasks are saved in JSON format
- **👤 User Profiles** - Personalized experience with user registration
- **🎯 Simple Interface** - Clean, intuitive menu-driven interface

## 🛠️ Tech Stack

- **Java** - Core programming language
- **Maven** - Dependency management and build tool
- **Gson** - JSON serialization/deserialization
- **JSON** - Lightweight data storage

## 📋 Prerequisites

- Java 8 or higher
- Maven 3.6+

## 🔧 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/todo-cli.git
   cd todo-cli
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn exec:java -Dexec.mainClass="com.omar.todo.TodoMain"
   ```

## 🎮 Usage

When you launch the application, you'll see a simple menu:

```
---To Do Cli Application---
Options:
1: Add a new task
2: Show your tasks
3: Quit
```

### Adding a Task
1. Select option `1`
2. Enter your task description
3. Press Enter to save

### Viewing Tasks
1. Select option `2`
2. All your tasks will be displayed with their numbers
3. Press Enter to return to the menu

### Exiting
Select option `3` to quit the application

## 📁 Project Structure

```
todo-cli/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── omar/
│                   └── todo/
│                       ├── TodoMain.java      # Main application entry
│                       ├── UserData.java      # User data model
│                       ├── Todoformat.java    # Todo item model
│                       ├── JsonEditor.java    # JSON operations
│                       └── todolist.json      # Data storage
├── pom.xml
└── README.md
```

## 📦 Dependencies

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

## 💡 Example

```
---To Do Cli Application---
Options:
1: Add a new task
2: Show your tasks
3: Quit
> 1

Please enter the task:
> Buy groceries
Task added successfully!

> 2
Your Tasks:
1. Buy groceries
2. Finish project
3. Call dentist
```

## 🔮 Future Enhancements

- [ ] Mark tasks as complete
- [ ] Delete tasks
- [ ] Edit existing tasks
- [ ] Task priorities
- [ ] Due dates
- [ ] Categories/tags
- [ ] Search functionality
- [ ] Export to different formats

## 🤝 Contributing

Contributions are welcome! Feel free to submit issues and pull requests.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👨‍💻 Author

**Omar Atakishiyev**

---

⭐ If you find this project useful, please consider giving it a star!

*Built with ☕ and Java*