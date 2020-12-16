package org.academiadecodigo.jupiter.controllers.assembler;

import org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

public class RecepiToDto {

    public RecipeDto convert(Recipe recipe){
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setCookingTime(recipeDto.getCookingTime());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setName(recipe.getName());
        recipeDto.setPhotoUrl(recipeDto.getPhotoUrl());
        return recipeDto;
    }
}
