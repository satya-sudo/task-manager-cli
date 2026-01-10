package service;

import exception.TaskNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import model.Task;
import model.TaskStatus;
import model.User;
import repository.TaskRepository;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String title) {
        Task task = new Task(title);
        repository.save(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return repository.List();
    }

    public void deleteTask(UUID id) {
        repository.delete(id);
    }

    public void assignUser(UUID id, User user) {
        Task task = getTask(id);
        task.assignedUser(user);
    }

    public void updateStatus(UUID id, TaskStatus status) {
        Task task = getTask(id);
        task.setStatus(status);
    }
    public List<Task> getTaskByStatus(TaskStatus status) {
        return repository.List()
        .stream()
        .filter(t -> t.getStatus() == status)
        .collect(Collectors.toList());
    }

    private Task getTask(UUID id) {
        try {
            return repository.findbyId(id);
        } catch (Exception e) {
            throw new TaskNotFoundException("Task Id:" + id.toString() + "Not found!");
        }
    }
}