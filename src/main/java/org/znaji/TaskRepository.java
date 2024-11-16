package org.znaji;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

        try {
            String fileAsString = Files.readString(jsonPath)
                    .replace("[\n", "")
                    .replace("\n]", "");
            if (fileAsString.isBlank()) {
                return tasks;
            }
            String[] tasksJsonArray = fileAsString
                    .split("},");
            for (String taskJson : tasksJsonArray) {
                if (!taskJson.endsWith("}")) {
                    taskJson += "}";
                }
                tasks.add(Task.fromJson(taskJson));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
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

    public List<Task> listAll() {
        return tasks;
    }

    private void writeToFile() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\n");
        for (Task task : tasks) {
            stringBuilder.append(task.toJson()).append(",");
        }
        stringBuilder.append("\n]");
        try {
            Files.writeString(
                   jsonPath,
                   stringBuilder.toString()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {

    }
}
