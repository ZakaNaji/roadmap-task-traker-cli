package org.znaji;

public class TaskService {


    final TaskRepository taskRepository = new TaskRepository();

    public void run(String... args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Command is required");
        }
        switch (args[0]) {
            case "add" -> addTask(args[1]);
            case "list" -> listTasks(args);
            case "update" -> updateTask(args);
            case "delete" -> deleteTask(args);
            case "mark" -> markTask(args);
            default -> throw new IllegalArgumentException("Unknown command: " + args[0]);
        }
    }

    private void markTask(String[] args) {
    }

    private void deleteTask(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Task ID is required");
        }
        final Long id = Long.parseLong(args[1]);
        taskRepository.delete(id);

    }

    private void updateTask(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Task ID and new name are required");
        }
        final Long id = Long.parseLong(args[1]);
        final String name = args[2];
        taskRepository.update(id, name);

    }

    private void listTasks(String[] args) {
        System.out.printf("%-5s %-40s %-10s%n", "ID", "Name", "Status");
        for (Task task : taskRepository.listTasks(args)) {
            System.out.printf("%-5d %-40s %-10s%n", task.getId(), task.getName(), task.getStatus());
        }
    }

    private void addTask(String name) {
        taskRepository.add(new Task(null, name, TaskStatus.TODO));
    }
}
