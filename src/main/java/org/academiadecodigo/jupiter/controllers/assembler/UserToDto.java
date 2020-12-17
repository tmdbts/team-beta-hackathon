package org.academiadecodigo.jupiter.controllers.assembler;

import org.academiadecodigo.jupiter.persistance.model.User;
import org.academiadecodigo.jupiter.persistance.model.dto.UserDto;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserToDto {

    public UserDto convert(User user) {

        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setId(user.getId());
        userDto.setLastName(user.getLastName());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());

        return userDto;
    }

    public List<UserDto> convert(List<User> users){
        List<UserDto> dtoList = new LinkedList<>();
        for (User user: users){
            dtoList.add(convert(user));
        }
        return dtoList;
    }
}