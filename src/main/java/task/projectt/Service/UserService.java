package task.projectt.Service;

import org.springframework.stereotype.Service;
import task.projectt.Payload.UserDto;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);
}
