package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.controllers.assembler.RecipeToDto;
import org.academiadecodigo.jupiter.controllers.assembler.RecipeToPedidoDto;
import org.academiadecodigo.jupiter.controllers.assembler.UserToDto;
import org.academiadecodigo.jupiter.persistance.model.dto.OrderCreationDto;
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
    RecipeToPedidoDto recipeToPedidoDto;

    @Autowired
    public void setRecipeToPedidoDto(RecipeToPedidoDto recipeToPedidoDto) {
        this.recipeToPedidoDto = recipeToPedidoDto;
    }

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
    public String loadRecipes(Model model, @RequestParam(name = "rcid", required = false) String rcid, @RequestParam(name = "brid", required = false) String brcid, @PathVariable(name = "uid", required = false) Integer uid, @RequestParam(name = "type", required = false) String type) {

        System.out.println("BRID1: " + brcid);
        if (brcid==null) brcid = "";
        if (brcid.equals(","));

        System.out.println("BRID2: " + brcid);
        List<Recipe> recipeList = new LinkedList<>();
        List<Integer> recipesIds = stringArraytoInt(rcid);
        List<Integer> blackListedIds = stringArraytoInt(brcid);

        System.out.println("BRID3: " + brcid);
        if (type == null) type = "";
        if (type.equals("vegan") || type.equals("healthy") || type.equals("vegetarian")) {
            recipeList = recipeService.generateRecipeList(recipesIds, blackListedIds, type);
        } else {
            recipeList = recipeService.generateRecipeList(recipesIds, blackListedIds);
        }

        System.out.println("BRID4: " + brcid);
        List<Integer> listIds = getRecipesIds(recipeList);
        List<RecipeDto> listConverted = recipeToDto.convert(recipeList);
        String rcid1 = getRCID(listIds);
        UserDto user = userToDto.convert(userService.getUser(uid));
        OrderCreationDto orderCreationDto = recipeToPedidoDto.convert(uid, 1, listConverted);

        System.out.println(rcid);

        if (brcid==null) brcid = "";

        model.addAttribute("userDto", user);
        model.addAttribute("rcid", rcid1);
        model.addAttribute("brid", brcid);
        model.addAttribute("list", orderCreationDto);

        return "index";
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private List<Integer> stringArraytoInt(String idsInString) {

        if (idsInString == null) return new LinkedList<>();
        if (idsInString.equals("")) return new LinkedList<>();

        String[] array = idsInString.split(",");
        LinkedList<Integer> list = new LinkedList<>();

        for (String number : array) {
            System.out.println("InsideMethod: " + number);
            if (number.equals("")) break;
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
            stringBuilder.append(id).append(",");
        }

        return stringBuilder.toString();
    }
}


