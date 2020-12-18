package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.controllers.assembler.UserToDto;
import org.academiadecodigo.jupiter.persistance.model.User;
import org.academiadecodigo.jupiter.persistance.model.dto.UserDto;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;
    private UserToDto userToDto;

    @Autowired
    public void setUserToDto(UserToDto userToDto) {
        this.userToDto = userToDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/user/{id}"})
    public String showOrder(@PathVariable Integer id, Model model) {

        User user = userService.getUser(id);
        UserDto userDto = userToDto.convert(user);
        model.addAttribute("userDto",userDto);

        return "userinfo";
    }
}
