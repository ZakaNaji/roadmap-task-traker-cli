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

    }

    private void updateTask(String[] args) {

    }

    private void listTasks(String[] args) {
        System.out.printf("%-5s %-20s %-10s%n", "ID", "Name", "Status");
        for (Task task : taskRepository.listAll()) {
            System.out.printf("%-5d %-20s %-10s%n", task.getId(), task.getName(), task.getStatus());
        }
    }

    private void addTask(String name) {
        taskRepository.add(new Task(null, name, TaskStatus.TODO));
    }
}
