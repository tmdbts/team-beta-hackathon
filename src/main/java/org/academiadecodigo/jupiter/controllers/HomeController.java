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


    UserServise userServise;
    UsertoDto usertoDto;



    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String defaultController(Model model, @PathVariable Integer id) {
        User user = userServise.get(id);
        UserDto userDto = usertoDto.convert(user);
        model.addAttribute(userDto);
        return "home";
    }


    @Autowired
    public void setUsertoDto(UsertoDto usertoDto) {
        this.usertoDto = usertoDto;
    }

    @Autowired
    public void setUserServise(UserServise userServise) {
        this.userServise = userServise;
    }


}
