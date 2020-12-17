package org.academiadecodigo.jupiter.controllers.assembler;

import org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<RecipeDto> convert(List<Recipe> list) {

        List<RecipeDto> conversions = new ArrayList<>(list.size());

        for (Recipe toConvert : list) {
            conversions.add(convert(toConvert));
        }
        
        return conversions;
    }

}
