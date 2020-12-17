package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.persistance.model.recipe.RecipeType;

public interface RecipeService {

    //generates a list of recipes of the same type
    list<Recipe> generateRecipeList(RecipeType recipeType);

    //generates 1 random recipe
    Recipe generateOneRandomRecipe(RecipeType recipeType);

    Recipe get(Integer id);
}
