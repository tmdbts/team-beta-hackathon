package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import java.util.List;

public class RecipeServiceInplementation implements RecipeService{

    private RecipeDao recipeDao;


    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }


    @Override
    public list<Recipe> generateRecipeList(RecipeType recipeType) {
        List<Recipe> recipeList;
       // recipeList = recipeDao
        //return recipeList;
    }

    @Override
    public Recipe generateOneRandomRecipe(RecipeType recipeType) {
        return null;
    }

    @Override
    public List<Recipe> shuffleRecipe(List<Integer> blackListedIds, List<Integer> recipeIds) {
        return null;
    }

    @Override
    public Recipe fetchRecipeById(int id) {

        return Recipe;
    }


}
