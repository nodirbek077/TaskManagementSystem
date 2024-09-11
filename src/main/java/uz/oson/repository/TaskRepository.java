package uz.oson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.oson.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
