package org.znaji;

public class Task {
    private Long id;
    private String name;
    private TaskStatus status;
    private String createdAt;
    private String updatedAt;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    public static Task fromJson(String takJson) {
        String[] attributes = takJson.replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .split(",");
        final Task task = new Task();
        task.setId(Long.parseLong(attributes[0].split(":")[1].strip()));
        task.setName(attributes[1].split(":")[1].strip());
        task.setStatus(Utils.getStatus(attributes[2].split(":")[1].strip()));
        task.setCreatedAt(attributes[3].split(":")[1].strip());
        task.setUpdatedAt(attributes[4].split(":")[1].strip());

        return task;
    }

    public String  toJson() {
        final String json = """
                {
                    "id": %d,
                    "name": "%s",
                    "status": "%s",
                    "createdAt": "%s",
                    "updatedAt": "%s"
                }""";
        return String.format(json, id, name, Utils.getStatus(status), createdAt, updatedAt);
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
