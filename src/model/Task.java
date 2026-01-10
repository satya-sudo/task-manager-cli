package model;

import java.util.UUID;

public class Task {
    private final UUID id;
    private final String title;
    private TaskStatus status;
    private User assignedUser;

    public Task(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.status = TaskStatus.TODO;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return  title;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    
    public void assignedUser(User user) {
        this.assignedUser = user;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + id + 
            ",title=" + title + 
            ",status=" + status + 
            ", assignedUser=" + (assignedUser != null ? assignedUser.getName() : "None") +
            "}";
    }

}