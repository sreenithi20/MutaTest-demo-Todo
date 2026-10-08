package com.example.todo;

public class Todo {

    private int id;
    private String title;
    private boolean completed;
    private String priority;

    public Todo(int id, String title, String priority) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Title cannot be empty");
        }
        if (!priority.equals("LOW") && 
            !priority.equals("MEDIUM") && 
            !priority.equals("HIGH")) {
            throw new IllegalArgumentException(
                "Priority must be LOW, MEDIUM, or HIGH");
        }
        this.id = id;
        this.title = title.trim();
        this.completed = false;
        this.priority = priority;
    }

    public void complete() {
        this.completed = true;
    }

    public void reopen() {
        this.completed = false;
    }

    public boolean isOverdue(int daysSinceCreated, int dueDays) {
        return !completed && daysSinceCreated > dueDays;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
    public String getPriority() { return priority; }
}