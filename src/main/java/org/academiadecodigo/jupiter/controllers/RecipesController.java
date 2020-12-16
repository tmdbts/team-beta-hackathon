package org.academiadecodigo.jupiter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/recipe")
public class RecipesController {

    RecipesService recipesService;
    RecepiToDto recepiToDto;

    @Autowired
    public void setRecepiToDto(RecepiToDto recepiToDto) {
        this.recepiToDto = recepiToDto;
    }


    @Autowired
    public void setRecipesService(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String showOrder(@PathVariable Integer id, Model model){
        Recipe recice = recipesService.get(id);
        RecipeDto recipeDto = recepiToDto.convert(recipe);
        model.addAttribute(recipeDto);
        return "recipe";
    }
}
