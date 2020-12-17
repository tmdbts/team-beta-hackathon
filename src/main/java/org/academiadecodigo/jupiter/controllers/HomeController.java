package org.academiadecodigo.jupiter.controllers;

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
    UsertoDto usertoDto;



    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String defaultController(Model model, @PathVariable Integer id) {
        User user = userService.getUser(id);
        UserDto userDto = usertoDto.convert(user);
        model.addAttribute("userDto",userDto);
        return "home";
    }


    @Autowired
    public void setUsertoDto(UsertoDto usertoDto) {
        this.usertoDto = usertoDto;
    }

    @Autowired
    public void setUserServise(UserService userServise) {
        this.userService = userServise;
    }


}
