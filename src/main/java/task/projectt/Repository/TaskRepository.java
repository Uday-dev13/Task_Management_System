package task.projectt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.projectt.Entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(long userid);
}
