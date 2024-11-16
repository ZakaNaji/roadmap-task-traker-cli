package org.znaji;

public class Task {
    private Long id;
    private String name;
    private TaskStatus status;

    public Task(Long id, String name, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public static Task fromJson(String takJson) {
        String[] attributes = takJson.replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .split(",");
        final Long id = Long.parseLong(attributes[0].split(":")[1].strip());
        final String name = attributes[1].split(":")[1].strip();
        final TaskStatus status = TaskStatus.valueOf(attributes[2].split(":")[1].strip());

        return new Task(id, name, status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String  toJson() {
        final String json = """
                {
                    "id": %d,
                    "name": "%s",
                    "status": "%s"
                }""";
        return String.format(json, id, name, status);
    }
}
