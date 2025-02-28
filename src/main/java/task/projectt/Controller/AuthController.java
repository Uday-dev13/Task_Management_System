package task.projectt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.projectt.Payload.UserDto;
import task.projectt.Service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // POST store the user in DB
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);



    }
}
