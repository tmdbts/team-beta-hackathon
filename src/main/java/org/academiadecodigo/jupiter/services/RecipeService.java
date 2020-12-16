package org.academiadecodigo.jupiter.services;

public interface RecipeService {

    //generates a list of recipes of the same type
    list<Recipe> generateRecipeList (RecipeType recipeType);


    //generates 1 random recipe
    Recipe generateOneRandomRecipe (RecipeType recipeType);


}
