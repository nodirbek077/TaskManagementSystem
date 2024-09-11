package uz.attolabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.attolabs.entity.Task;
import uz.attolabs.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping(value = "/add")
    public HttpEntity<?> addTask(@RequestBody Task task){
        Task newTask = taskService.addTask(task);
        return ResponseEntity.status(201).body(newTask);
    }

    @GetMapping()
    public HttpEntity<?> getTasks(){
       List<Task> taskList = taskService.getTasks();
       return (taskList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(taskList));
    }
}
