package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import model.Task;

public class TaskRepository {
    private final Map<UUID, Task> tasks = new HashMap<>();
    
    public void save( Task task)   {
        tasks.put(task.getId(), task);
    }

    public Task findbyId( UUID id) {
        Task task = tasks.get(id);
        if (task == null ){
            throw new NoSuchElementException("No Such Task found" +  id);
        }
        return task;
    }

    public List<Task> List() {
        return new ArrayList<>(tasks.values());
    }

    public void delete(UUID id) {
        if (!tasks.containsKey(id)) {
            throw new NoSuchElementException("No Such Task found  with id:" + id);
        }
        tasks.remove(id);
    }
}