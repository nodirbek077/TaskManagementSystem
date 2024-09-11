package uz.oson.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import uz.oson.entity.Task;
import uz.oson.entity.TaskStatus;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TaskServiceTest {
    @Mock
    TaskService taskService;

    @InjectMocks
    Task task;

    public TaskServiceTest() {
        MockitoAnnotations.openMocks(this);
        task = new Task(1L, "Test Task", "Test Description", LocalDate.now(), TaskStatus.OPEN);
    }

    @Test
    void testAddTask() {
        when(taskService.addTask(task)).thenReturn(task);
        Task createdTask = taskService.addTask(task);
        assertEquals("Test Task Title", createdTask.getTitle());
    }

    @Test
    void testUpdateTask() {
        Task updatedTask = new Task(1L, "Updated Task", "Updated Description", LocalDate.now(), TaskStatus.IN_PROGRESS);
        when(taskService.updateTask(1L, updatedTask)).thenReturn(Optional.of(updatedTask));
        Optional<Task> result = taskService.updateTask(1L, updatedTask);
        assertEquals("Updated Task", result.get().getTitle());
    }
}
