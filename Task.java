public class Task {
    private final String taskId; 
    private String name; 
    private String description; 

    // Constructor to create a Task object with validation
    public Task(String taskId, String name, String description) {
        // Making sure taskId is not null and doesn't go over 10 characters
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null and max 10 chars");
        }
        // Making sure name is not null and doesn't go over 20 characters
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and max 20 chars");
        }
        // Making sure description is not null and doesn't go over 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and max 50 chars");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // access private variables
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //  update name if it's valid
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and max 20 chars");
        }
        this.name = name;
    }

    //  update description if it's valid
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and max 50 chars");
        }
        this.description = description;
    }
}