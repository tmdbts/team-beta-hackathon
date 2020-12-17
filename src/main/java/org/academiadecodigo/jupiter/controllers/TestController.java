package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.controllers.assembler.UserToDto;
import org.academiadecodigo.jupiter.persistance.model.dto.UserDto;
import org.academiadecodigo.jupiter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TestController {


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    UserService userService;
    UserToDto userToDto;

    @Autowired
    public void setUserToDto(UserToDto userToDto) {
        this.userToDto = userToDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"","/"})
    public String defaultController(Model model) {
        List<UserDto> listUserDto = userToDto.convert(userService.listUsers());
        model.addAttribute("listUsers",listUserDto);
        return "fakeLogin";
    }
}
