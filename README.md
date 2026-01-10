# Task Manager CLI (Java)

A simple **interactive command-line Task Manager** built using core Java.  
The project focuses on **clean architecture**, **separation of concerns**, and **Java fundamentals** without frameworks.

---

## ✨ Features

- Create tasks
- List all tasks
- Update task status (`TODO`, `IN_PROGRESS`, `DONE`)
- List tasks by status
- Delete tasks
- Create users
- Assign users to tasks
- Interactive CLI with safe input handling

---

## 🏗️ Project Structure

```

src/
├── Main.java
├── cli/
│   └── CommandHandler.java
├── model/
│   ├── Task.java
│   ├── User.java
│   └── TaskStatus.java
├── repository/
│   ├── TaskRepository.java
│   └── UserRepository.java
├── service/
│   └── TaskService.java
└── exception/
└── TaskNotFoundException.java

```

---

## 🧠 Architecture Overview

```

CLI (CommandHandler)
↓
Service Layer (TaskService)
↓
Repositories (TaskRepository, UserRepository)
↓
Domain Models (Task, User)

````

### Design Principles Used
- **Separation of Concerns**
- **Programming to interfaces**
- **Thin CLI, fat service**
- **In-memory repositories**
- **UUID-based identity**
- **Enum-based state control**

---

## 🚀 How to Run

### Prerequisites
- Java 17+
- Terminal (macOS / Linux / Windows)

### Compile
```bash
javac -d out $(find src -name "*.java")
````

### Run

```bash
java -cp out Main
```

---

## 📋 CLI Menu

```
1. Create Task
2. List All Tasks
3. Delete Task
4. Update Task Status
5. Create User
6. Assign User to Task
7. List Tasks By Status
8. Exit
```

---

## 🧪 Example Workflow

1. Create a user
2. Create a task
3. Assign the user to the task
4. Update task status
5. List tasks by status

---

## ❗ Error Handling

* Invalid input is handled gracefully
* Invalid UUIDs are rejected
* Missing tasks throw domain-specific exceptions
* CLI never crashes on bad input

---

## 🎯 Why This Project?

This project was built to:

* Re-learn **core Java fundamentals**
* Avoid framework abstraction
* Demonstrate clean backend thinking
* Be easily extendable (REST API, persistence, Spring Boot)

---

## 🔮 Possible Extensions

* File-based persistence
* REST API (Spring Boot)
* Database integration
* Authentication
* Unit tests

---

## 🧑‍💻 Author

**Satyam Shree**

---

## 📄 License

MIT

