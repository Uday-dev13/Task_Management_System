package task.projectt.Mapper;

import task.projectt.Entity.Users;
import task.projectt.Payload.UserDto;

public class UserMapper {

    public static Users mapToUsers(UserDto userDto){
        Users user = new Users();
                user.setEmail(userDto.getEmail());
//                user.setId(userDto.getId());
                user.setName(userDto.getName());
                user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto mapToUserDto(Users user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
