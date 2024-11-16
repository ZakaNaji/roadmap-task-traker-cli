package org.znaji;

import java.util.Date;
import java.util.Map;

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
        final TaskStatus taskStatus = Utils.getStatus(status);
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
        System.out.printf("%-5s %-55s %-10s %-15s %-15s%n", "ID", "Name", "Status", "Created At", "Updated At");
        for (Task task : taskRepository.listTasks(args)) {
            System.out.printf("%-5d %-55s %-10s %-15s %-15s%n", task.getId(), task.getName(), task.getStatus(), task.getCreatedAt(), task.getUpdatedAt());
        }
    }

    private void addTask(String name) {
        final Task task = new Task(name);
        task.setCreatedAt(Utils.formatDate(new Date()));
        task.setStatus(TaskStatus.TODO);
        taskRepository.add(task);
    }

}
