// MutaTest CI/CD verification trigger
package com.example.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoService {

    private List<Todo> todos = new ArrayList<>();
    private int nextId = 1;

    public Todo addTodo(String title, String priority) {
        Todo todo = new Todo(nextId++, title, priority);
        todos.add(todo);
        return todo;
    }

    public boolean completeTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.complete();
                return true;
            }
        }
        return false;
    }

    public boolean deleteTodo(int id) {
        return todos.removeIf(t -> t.getId() == id);
    }

    public List<Todo> getPendingTodos() {
        return todos.stream()
            .filter(t -> !t.isCompleted())
            .collect(Collectors.toList());
    }

    public List<Todo> getCompletedTodos() {
        return todos.stream()
            .filter(Todo::isCompleted)
            .collect(Collectors.toList());
    }

    public List<Todo> getTodosByPriority(String priority) {
        return todos.stream()
            .filter(t -> t.getPriority().equals(priority))
            .collect(Collectors.toList());
    }

    public int getTotalCount() {
        return todos.size();
    }

    public double getCompletionRate() {
        if (todos.isEmpty()) return 0.0;
        long completed = todos.stream()
            .filter(Todo::isCompleted).count();
        return (double) completed / todos.size() * 100;
    }
}