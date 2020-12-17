package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.controllers.assembler.RecipeToDto;
import org.academiadecodigo.jupiter.controllers.assembler.UserToDto;
import org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto;
import org.academiadecodigo.jupiter.persistance.model.dto.UserDto;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.services.OrderService;
import org.academiadecodigo.jupiter.services.RecipeService;
import org.academiadecodigo.jupiter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;
    RecipeService recipeService;
    RecipeToDto recipeToDto;
    UserService userService;
    UserToDto userToDto;

    @Autowired
    public void setUserToDto(UserToDto userToDto) {
        this.userToDto = userToDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRecipeToDto(RecipeToDto recipeToDto) {
        this.recipeToDto = recipeToDto;
    }

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{uid}")
    public String loadRecipes(Model model, @RequestParam("rcid") String rcid, @RequestParam("brid") String brcid, @PathVariable("uid") Integer uid, @RequestParam("type") String type) {
        List<Recipe> recipeList = new LinkedList<>();
        List<Integer> recipesIds = stringArraytoInt(rcid);
        List<Integer> blackListedIds = stringArraytoInt(brcid);
        if (type.equals("vegan") || type.equals("healthy") || type.equals("balanced")) {
            recipeList = recipeService.generateRecipes(recipesIds, blackListedIds, type);
        } else {
            recipeList = recipeService.generateRecipes(recipesIds, blackListedIds);
        }
        List<Integer> listIds = getRecipesIds(recipeList);
        String rcid1 = getRCID(listIds);
        List<RecipeDto> listConverted = recipeToDto.convert(recipeList);
        UserDto user = userToDto.convert(userService.getUser(uid));
        model.addAttribute("userDto", user);
        model.addAttribute("recipeDtoList", listConverted);
        model.addAttribute("rcid", rcid1);
        model.addAttribute("brid", blackListedIds);
        return "index";
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private List<Integer> stringArraytoInt(String idsInString) {

        if (idsInString.equals("")) return new LinkedList<>();

        String[] array = idsInString.split(",");
        LinkedList<Integer> list = new LinkedList<>();

        for (String number : array) {
            list.add(Integer.valueOf(number));
        }

        return list;
    }

    private List<Integer> getRecipesIds(List<Recipe> recipesList) {
        LinkedList<Integer> listIds = new LinkedList<Integer>();
        for (Recipe recipe : recipesList) {
            listIds.add(recipe.getId());
        }
        return listIds;
    }

    private String getRCID(List<Integer> listOfIds) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer id : listOfIds) {
            stringBuilder.append(id + ",");
        }
        return stringBuilder.toString();
    }
}


