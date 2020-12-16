package org.academiadecodigo.jupiter.services;

public class RecipeServiceInplementation implements RecipeService{

    private RecipeDao recipeDao;


    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }


    @Override
    public list<Recipe> generateRecipeList(RecipeType recipeType) {
        return null;
    }

    @Override
    public Recipe generateOneRandomRecipe(RecipeType recipeType) {
        return null;
    }




}
