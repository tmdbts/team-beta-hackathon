package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.controllers.assembler.UserToDto;
import org.academiadecodigo.jupiter.persistance.model.User;
import org.academiadecodigo.jupiter.persistance.model.dto.UserDto;
import org.academiadecodigo.jupiter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    UserService userService;
    UserToDto userToDto;


    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String defaultController(Model model, @PathVariable Integer id) {

        User user = userService.getUser(id);
        UserDto userDto = userToDto.convert(user);

        model.addAttribute("userDto", userDto);

        return "home";
    }


    @Autowired
    public void setUserToDto(UserToDto usertoDto) {
        this.userToDto = usertoDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
