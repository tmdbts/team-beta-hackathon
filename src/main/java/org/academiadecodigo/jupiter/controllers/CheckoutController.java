package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.persistance.model.dto.OrderCreationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CheckoutController {

    @RequestMapping(method = RequestMethod.GET ,value = "/checkout")
    public String postCart(){
        return "Checkout";
    }
}
