package org.academiadecodigo.jupiter.controllers;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.services.OrderService;
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

    // Can serve URLs like http://www.someserver.org/someapp/hello?name=catarina
    @RequestMapping(method = RequestMethod.GET, value = "/{uid}")
    public String loadRecipes(Model model, @RequestParam("rcid") String rcid, @RequestParam("brid") String brcid, @PathVariable("uid") Integer uid) {

        //Falta trtar casos NULl
        List<Integer> recipesIds = stringArraytoInt(rcid);
        List<Integer> blackListedIds = stringArraytoInt(brcid);
//        List<Recipe> recipesList = orderService.getRecipes(recipesIds, blackListedIds);
//        List<Recipe> recipesList = orderService.listOrders(recipesIds, blackListedIds);

//        TODO: Add types

        model.addAttribute("recipes", recipesList);

        if (recipesIds != null) {
            model.addAttribute("recipes", recipesList);
        }

        model.addAttribute("rcid", recipesIds);
        model.addAttribute("brid", blackListedIds);

        return "home";
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private List<Integer> stringArraytoInt(String idsInString) {

        if (idsInString.equals("")) return null;

        String[] array = idsInString.split(",");
        LinkedList<Integer> list = new LinkedList<>();

        for (String number : array) {
            list.add(Integer.valueOf(number));
        }

        return list;
    }
}


