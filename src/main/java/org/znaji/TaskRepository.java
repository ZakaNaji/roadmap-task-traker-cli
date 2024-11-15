package org.znaji;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class TaskRepository {
    private final Path jsonPath = Path.of("tasks.json");
    final List<Task> tasks;

    public TaskRepository() {
        this.tasks = loadArray();
    }


    private List<Task> loadArray() {
        final List<Task> tasks = new ArrayList<>();
        String[] tasksJsonArray = Files.readString(jsonPath).replace("[", "")
                .replace("]", "")
                .split("},");
        for (String taskJson : tasksJsonArray) {
            tasks.add(Task.fromJson(taskJson));
        }

    }

    public void add(Task task) {
        final Long id = tasks.stream()
                .map(Task::getId)
                .max(Long::compareTo)
                .orElse(0L);
        task.setId(id + 1);
        tasks.add(task);
        writeToFile();
    }

    public String listAll() {
        return null;
    }

    private void writeToFile() {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            final String tasksJson = createTasksJson();
            fileOutputStream.write(tasksJson.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String createTasksJson() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    private void readFromFile() {

    }
}
