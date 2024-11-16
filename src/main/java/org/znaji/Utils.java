package org.znaji;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Utils {

    final static Map
            <String, TaskStatus> statusMap = Map.of(
            "todo", TaskStatus.TODO,
            "done", TaskStatus.DONE,
            "in-progress", TaskStatus.IN_PROGRESS
    );

    public static String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    public static TaskStatus getStatus(String status) {
        if (status == null) {
            throw new IllegalArgumentException("Status is required");
        }
        return statusMap.get(status.toLowerCase());
    }

    public static String getStatus(TaskStatus status) {
        return statusMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(status))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid status"));
    }

    public static String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        return name;
    }

    public static long validateId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid ID");
        }
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID");
        }

    }
}
