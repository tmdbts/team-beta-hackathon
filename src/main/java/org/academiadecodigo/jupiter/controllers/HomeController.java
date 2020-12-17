package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.controllers.assembler.UserToDto;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.services.RecipeService;
import org.academiadecodigo.jupiter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    UserService userService;
    UserToDto userToDto;
    RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String defaultController(@PathVariable Integer id) {

        List<Recipe> randomRecipes = recipeService.generateRecipeList();
        String recipesIds = getRecipesIds(randomRecipes);

        return "redirect:/order/" + id + "?rcid=" + recipesIds;
    }

    @Autowired
    public void setUserToDto(UserToDto userToDto) {
        this.userToDto = userToDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String getRecipesIds(List<Recipe> list) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Recipe recipe : list) {
            stringBuilder.append(recipe.getId() + ",");
        }

        return stringBuilder.toString();
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/test"})
    public String showTest() {
        return "test";
    }
}
