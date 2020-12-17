package org.academiadecodigo.jupiter.persistance.dao;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import java.util.List;

public interface RecipeDao extends Dao<Recipe>{

    List<Recipe> findAllByType(String type);

}
