package uz.oson.service;

import org.springframework.stereotype.Service;
import uz.oson.entity.Task;
import uz.oson.exception.InvalidTaskException;
import uz.oson.exception.TaskNotFoundException;
import uz.oson.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task){
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new InvalidTaskException("Task title cannot be null or empty.");
        }

        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return Optional.ofNullable(taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setDueDate(updatedTask.getDueDate());
                    task.setStatus(updatedTask.getStatus());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new TaskNotFoundException(id)));
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
