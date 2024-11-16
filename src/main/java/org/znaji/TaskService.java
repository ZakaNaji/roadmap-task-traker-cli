package org.znaji;

import java.util.Map;

public class TaskService {


    final TaskRepository taskRepository = new TaskRepository();
    final Map
            <String, TaskStatus> statusMap = Map.of(
            "todo", TaskStatus.TODO,
            "done", TaskStatus.DONE,
            "in-progress", TaskStatus.IN_PROGRESS
    );

    public void run(String... args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Command is required");
        }
        switch (args[0]) {
            case "add" -> addTask(args[1]);
            case "list" -> listTasks(args);
            case "update" -> updateTask(args);
            case "delete" -> deleteTask(args);
            default -> {
                if (args[0].startsWith("mark-")) {
                    markTask(args);
                } else {
                    throw new IllegalArgumentException("Invalid command");
                }
            }
        }
    }

    private void markTask(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Task ID is required");
        }
        final String status = args[0].replace("mark-", "").toLowerCase();
        final Long id = Long.parseLong(args[1]);
        final TaskStatus taskStatus = statusMap.get(status);
        taskRepository.markTask(id, taskStatus);
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
