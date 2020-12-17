package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.dao.RecipeDao;
import org.academiadecodigo.jupiter.persistance.model.AbstractModel;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImplementation implements RecipeService {

    private RecipeDao recipeDao;

    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    @Autowired
    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @Override
    public List<Recipe> generateRecipeList(String recipeType) {

        List<Recipe> allRecipes = recipeDao.findAllByType(recipeType);
        List<Recipe> randomTypeRecipes = new ArrayList<>();

        while (randomTypeRecipes.size() < 8) {
            int random = ((int) (Math.random()) * allRecipes.size());

            if (!randomTypeRecipes.contains(allRecipes.get(random))) {
                randomTypeRecipes.add(allRecipes.get(random));
            }
        }

        return randomTypeRecipes;
    }

    @Override
    public List<Recipe> generateRecipeList() {

        List<Recipe> allRecipes = recipeDao.findAll();
        List<Recipe> randomRecipes = new ArrayList<>();

        while (randomRecipes.size() < 8) {
            int random = ((int) (Math.random()) * allRecipes.size());

            if (!randomRecipes.contains(allRecipes.get(random))) {
                randomRecipes.add(allRecipes.get(random));
            }
        }

        return randomRecipes;

    }


    @Override
    public List<Recipe> generateRecipeList(List<Integer> recipes, List<Integer> blacklist) {

        List<Recipe> allRecipes = recipeDao.findAll();
        List<Integer> allRecipesIds = allRecipes.stream()
                .map(r -> r.getId())
                .collect(Collectors.toList());

        recipes = recipes.stream().filter(blacklist::contains).collect(Collectors.toList());

        while (recipes.size() < 8) {
            int random = ((int) (Math.random()) * allRecipesIds.size());

            if (!recipes.contains(allRecipesIds.get(random))) {
                recipes.add(allRecipesIds.get(random));
            }
        }

        return recipes.stream().map(x -> recipeDao.findById(x)).collect(Collectors.toList());
    }

    @Override
    public List<Recipe> generateRecipeList(List<Integer> recipes, List<Integer> blacklist, String recipeType) {

        List<Recipe> allRecipes = recipeDao.findAllByType(recipeType);
        List<Integer> allRecipesIds = allRecipes.stream()
                .map(AbstractModel::getId)
//                Se der mrd fk intellij
                .collect(Collectors.toList());

        recipes = recipes.stream().filter(blacklist::contains).collect(Collectors.toList());

        while (recipes.size() < 8) {
            int random = ((int) (Math.random()) * allRecipesIds.size());

            if (!recipes.contains(allRecipesIds.get(random))) {
                recipes.add(allRecipesIds.get(random));
            }
        }

        return recipes.stream().map(x -> recipeDao.findById(x)).collect(Collectors.toList());
    }

    @Override
    public Recipe get(Integer id) {
        return recipeDao.findById(id);
    }

//    TODO: Ingredients to string
}