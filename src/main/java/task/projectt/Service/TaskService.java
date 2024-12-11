package task.projectt.Service;

import org.springframework.stereotype.Service;
import task.projectt.Payload.TaskDto;

import java.util.List;

@Service
public interface TaskService {

    TaskDto saveTask(long userid, TaskDto taskDto);

    List<TaskDto> getAllTasks(long userid);

    public TaskDto getTask(long userid, long taskid);

    public void deleteTask(long userid, long taskid);
}
