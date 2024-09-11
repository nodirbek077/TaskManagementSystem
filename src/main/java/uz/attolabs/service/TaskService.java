package uz.attolabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.attolabs.entity.Task;
import uz.attolabs.repository.TaskRepository;
import uz.attolabs.util.DateUtil;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Task addTask(Task task){
        Task newTask = new Task();
        DateUtil dateUtil = new DateUtil();

        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setDueDate(dateUtil.getDate(task.getDueDate()));
        return newTask;
    }

    public List<Task> getTasks() {
        return null;
    }
}
