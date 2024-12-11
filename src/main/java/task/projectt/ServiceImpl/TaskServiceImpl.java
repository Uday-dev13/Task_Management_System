package task.projectt.ServiceImpl;

import ch.qos.logback.core.model.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.projectt.Entity.Task;
import task.projectt.Entity.Users;
import task.projectt.Exception.APIException;
import task.projectt.Exception.TaskNotFound;
import task.projectt.Exception.UserNotFound;
import task.projectt.Payload.TaskDto;
import task.projectt.Repository.TaskRepository;
import task.projectt.Repository.UserRepository;
import task.projectt.Service.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TaskDto saveTask(long userid, TaskDto taskDto) {
        Users user = userRepo.findById(userid)
                .orElseThrow(()-> new UserNotFound("User with Id "+userid+" not found!"));
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUser(user);
        Task savedTask = taskRepo.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userid) {
        Users user = userRepo.findById(userid)
                .orElseThrow(()-> new UserNotFound("User with Id "+userid+" not found!"));
        List<Task> tasks = taskRepo.findAllByUserId(userid);
        return tasks.stream().map(
                task -> modelMapper.map(task, TaskDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTask(long userid, long taskid) {
        Users user = userRepo.findById(userid)
                .orElseThrow(()-> new UserNotFound("User with Id "+userid+" not found!"));
        Task task = taskRepo.findById(taskid)
                .orElseThrow(()-> new TaskNotFound("Task with Id "+taskid+" not found!"));
        if(user.getId() != task.getUser().getId()){
            throw new APIException("Task Id "+taskid+" is not belongs to User Id "+userid);
        }
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public void deleteTask(long userid, long taskid) {
        Users user = userRepo.findById(userid)
                .orElseThrow(()-> new UserNotFound("User with Id "+userid+" not found!"));
        Task task = taskRepo.findById(taskid)
                .orElseThrow(()-> new TaskNotFound("Task with Id "+taskid+" not found!"));
        if(user.getId() != task.getUser().getId()){
            throw new APIException("Task Id "+taskid+" is not belongs to User Id "+userid);
        }
        taskRepo.deleteById(taskid); // deletes the task

    }
}
