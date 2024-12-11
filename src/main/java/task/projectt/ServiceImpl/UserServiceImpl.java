package task.projectt.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.projectt.Entity.Users;
import task.projectt.Mapper.UserMapper;
import task.projectt.Payload.UserDto;
import task.projectt.Repository.UserRepository;
import task.projectt.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = UserMapper.mapToUsers(userDto);
        Users savedUser = userRepo.save(user);
        // userDto is not an entity of Users
        return UserMapper.mapToUserDto(savedUser);
    }
}
