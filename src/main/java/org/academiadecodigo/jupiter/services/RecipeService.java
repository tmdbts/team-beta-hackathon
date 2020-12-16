package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

public interface RecipeService {

    //generates a list of recipes of the same type
    list<Recipe> generateRecipeList(RecipeType recipeType);


    //generates 1 random recipe
    Recipe generateOneRandomRecipe(RecipeType recipeType);

    //generates random recipe having in count the ones the customer didn't like and the ones he selected.
    List<Recipe> shuffleRecipe(List<Integer> blackListedIds, List<Integer>recipeIds);


    // fetch a recipe by id
    Recipe fetchRecipeById(int id);
}
