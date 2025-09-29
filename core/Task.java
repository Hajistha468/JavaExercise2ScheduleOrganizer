package core;

public class Task {
    private String description;
    private String startTime;
    private String endTime;
    private TaskPriority priority;
    private boolean completed = false;

    public Task(String description, String startTime, String endTime, TaskPriority priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    // Getters and Setters
    public String getDescription() { return description; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public TaskPriority getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
