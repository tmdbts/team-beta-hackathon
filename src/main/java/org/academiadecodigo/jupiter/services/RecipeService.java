package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import java.util.List;

public interface RecipeService {

    /**
     * Generates a list of recipes of the same type
     *
     * @param recipeType Recipe type
     * @return List of recipes
     */
    List<Recipe> generateRecipeList(String recipeType);

    List<Recipe> generateRecipeList();

    List<Recipe> generateRecipeList(List<Integer> recipes, List<Integer> blacklist);

    List<Recipe> generateRecipeList(List<Integer> recipes, List<Integer> blacklist, String recipeType);

    Recipe get(Integer id);
}
