package uz.attolabs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uz.attolabs.entity.Task;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task,Long> {
//    @Query("SELECT t FROM Tasks t")
//    List<Task> findAllTasks();
}
