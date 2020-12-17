package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.dao.RecipeDao;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.persistance.model.recipe.RecipeType;

import java.util.List;

public class RecipeServiceInplementation implements RecipeService{

    private RecipeDao recipeDao;


    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }


    @Override
    public List<Recipe> generateRecipeList(RecipeType recipeType) {
        return null;
    }

    @Override
    public Recipe generateOneRandomRecipe(RecipeType recipeType) {
        return null;
    }




}
