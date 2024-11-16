
# Task Tracker CLI

Task Tracker CLI is a simple command-line application developed in Java to help you manage your tasks efficiently. 
It allows you to add, list, update, delete, and mark tasks with different statuses.

---

## Features

- **Add Tasks**: Create new tasks with a specified name.
- **List Tasks**: Display all tasks or filter them by status.
- **Update Tasks**: Modify the name of an existing task.
- **Delete Tasks**: Remove tasks by their ID.
- **Mark Tasks**: Change the status of tasks to `TODO`, `IN_PROGRESS`, or `DONE`.

---

## Prerequisites

- **Java 17** or higher installed on your system.

---

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/ZakaNaji/roadmap-task-traker-cli.git
cd roadmap-task-traker-cli
```

### 2. Compile the Application

```bash
javac -d out src/org/znaji/*.java
```

This command compiles the Java source files and places the compiled classes in the `out` directory.

---

## Usage

Run the application using the `java` command, specifying the classpath and the main class.

```bash
java -cp out org.znaji.TaskCLI <command> [arguments]
```

Replace `<command>` and `[arguments]` with the desired operation and its parameters.

---

## Commands

- **Add a Task**

  ```bash
  java -cp out org.znaji.TaskCLI add "Task Name"
  ```

  *Example:*

  ```bash
  java -cp out org.znaji.TaskCLI add "Complete project documentation"
  ```

- **List Tasks**

  ```bash
  java -cp out org.znaji.TaskCLI list
  ```

  To list tasks by status:

  ```bash
  java -cp out org.znaji.TaskCLI list <status>
  ```

  *Example:*

  ```bash
  java -cp out org.znaji.TaskCLI list done
  ```

- **Update a Task**

  ```bash
  java -cp out org.znaji.TaskCLI update <task-id> "New Task Name"
  ```

  *Example:*

  ```bash
  java -cp out org.znaji.TaskCLI update 1 "Review project requirements"
  ```

- **Delete a Task**

  ```bash
  java -cp out org.znaji.TaskCLI delete <task-id>
  ```

  *Example:*

  ```bash
  java -cp out org.znaji.TaskCLI delete 2
  ```

- **Mark a Task**

  ```bash
  java -cp out org.znaji.TaskCLI mark-<status> <task-id>
  ```

  Replace `<status>` with one of the following:

  - `todo`
  - `in-progress`
  - `done`

  *Examples:*

  ```bash
  java -cp out org.znaji.TaskCLI mark-in-progress 3
  java -cp out org.znaji.TaskCLI mark-done 3
  ```

---

## Data Storage

Tasks are stored in a `tasks.json` file located in the application's root directory. Ensure you have the necessary permissions to read and write to this file.

---

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or suggestions, please open an issue in the repository.
