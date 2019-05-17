package com.sadikul.sample.rxandroid.Model;

public class Task {
    String description;
    boolean isCompleted;
    int priority;

    public Task(String description, boolean isCompleted, int priority) {
        this.description = description;
        this.isCompleted = isCompleted;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
