package task.projectt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.projectt.Payload.TaskDto;
import task.projectt.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Save the task
    @PostMapping("/{userid}/tasks")
    public ResponseEntity<TaskDto> saveTask(
            @PathVariable(name="userid") long userid,
            @RequestBody TaskDto taskDto
    ){
        return new ResponseEntity<>(taskService.saveTask(userid,taskDto), HttpStatus.CREATED);
    }

    // Get all task
    @GetMapping("/{userid}/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(
            @PathVariable(name = "userid") long userid
            ){
        return new ResponseEntity<>(taskService.getAllTasks(userid), HttpStatus.OK);
    }

    // Get individual task
    @GetMapping("/{userid}/tasks/{taskid}")
    public ResponseEntity<TaskDto> getTask(
            @PathVariable(name = "userid") long userid,
            @PathVariable(name = "taskid") long taskid
    ){
        return new ResponseEntity<>(taskService.getTask(userid,taskid), HttpStatus.OK);
    }

    // Delete the task
    @DeleteMapping("/{userid}/tasks/{taskid}")
    public ResponseEntity<String> deleteTask(
            @PathVariable(name = "userid") long userid,
            @PathVariable(name = "taskid") long taskid
    ){
        taskService.deleteTask(userid,taskid);
        return new ResponseEntity<>("Task deleted Successfully!", HttpStatus.OK);
    }
}
