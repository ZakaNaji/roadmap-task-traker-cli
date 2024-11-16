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
        return statusMap.get(status);
    }

    public static String getStatus(TaskStatus status) {
        return statusMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(status))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid status"));
    }
}
