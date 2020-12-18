package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.persistance.model.recipe.RecipeType;

import java.util.List;

public interface RecipeService {

    /**
     * Generates a list of recipes of the same type
     *
     * @param recipeType Recipe type
     * @return List of recipes
     */

    List<Recipe> generateRecipeList(RecipeType recipeType);

    List<Recipe> generateRecipeList();

    List<Recipe> generateRecipeList(List<Integer> recipes, List<Integer> blacklist);

    List<Recipe> generateRecipeList(List<Integer> recipes, List<Integer> blacklist, RecipeType recipeType);

    Recipe get(Integer id);
}
