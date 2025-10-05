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
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── omar/
│                   └── todo/
│                       ├── TodoMain.java       # Main application entry
│                       ├── UserData.java       # User data model
│                       ├── Todoformat.java     # Todo item model
│                       ├── JsonEditor.java     # JSON operations & utilities
│                       └── todolist.json       # Data storage (auto-generated)
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
- Your data persists between sessions
- First-time users are prompted to register their name

### Input Validation
- Invalid inputs are caught and user is prompted to retry
- Task IDs are verified before operations
- Helpful error messages guide the user

## 🔮 Future Enhancements

- [ ] Edit existing tasks
- [ ] Task priorities (high, medium, low)
- [ ] Due dates and reminders
- [ ] Categories/tags for organization
- [ ] Search functionality
- [ ] Sort and filter options
- [ ] Export to different formats (CSV, PDF)
- [ ] Undo/redo functionality
- [ ] Recurring tasks

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