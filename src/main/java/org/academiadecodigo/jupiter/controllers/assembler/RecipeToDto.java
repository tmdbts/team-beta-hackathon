package org.academiadecodigo.jupiter.controllers.assembler;

import org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

public class RecipeToDto {

    public RecipeDto convert(Recipe recipe) {

        RecipeDto recipeDto = new RecipeDto();

        recipeDto.setId(recipe.getId());
        recipeDto.setCookingTime(recipe.getCookingTime());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setName(recipe.getName());
        recipeDto.setPhotoUrl(recipe.getPhotoUrl());

        return recipeDto;
    }
}
