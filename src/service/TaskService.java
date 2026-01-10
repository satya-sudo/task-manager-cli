package service;

import exception.TaskNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import model.Task;
import model.TaskStatus;
import model.User;
import repository.TaskRepository;
import repository.UserRepository;

public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(String title) {
        Task task = new Task(title);
        taskRepository.save(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return taskRepository.List();
    }

    public void deleteTask(UUID id) {
        taskRepository.delete(id);
    }

    public void assignUser(UUID taskId, User user) {
        Task task = getTask(taskId);
        task.assignedUser(user);
    }

    public void updateStatus(UUID id, TaskStatus status) {
        Task task = getTask(id);
        task.setStatus(status);
    }
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.List()
        .stream()
        .filter(t -> t.getStatus() == status)
        .collect(Collectors.toList());
    }

    private Task getTask(UUID id) {
        try {
            return taskRepository.findbyId(id);
        } catch (Exception e) {
            throw new TaskNotFoundException("Task Id:" + id.toString() + "Not found!");
        }
    }

    public User createUser(String name) {
        User user = new User(name);
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.list();
    }
    public User getUser(UUID id) {
        try {
            return userRepository.getUserById(id);
        } catch (Exception e) {
            throw new TaskNotFoundException("User Id:" + id.toString() + "Not found!");
        }
    }
}