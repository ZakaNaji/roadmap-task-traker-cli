package org.znaji;

public class TaskCLI {

    public static void main(String[] args) {
        final TaskService taskService = new TaskService();

        taskService.run(args);
    }
}