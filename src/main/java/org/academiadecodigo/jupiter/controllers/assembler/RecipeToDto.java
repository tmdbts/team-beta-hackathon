package org.academiadecodigo.jupiter.controllers.assembler;

import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeToDto {

    public org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto convert(Recipe recipe) {

        org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto recipeDto = new org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto();

        recipeDto.setId(recipe.getId());
        recipeDto.setCookingTime(recipe.getCookingTime());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setName(recipe.getName());
        recipeDto.setPhotoUrl(recipe.getPhotoUrl());

        return recipeDto;
    }

    public List<org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto> convert(List<Recipe> list) {

        List<org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto> conversions = new ArrayList<>(list.size());

        for (Recipe toConvert : list) {
            conversions.add(convert(toConvert));
        }

        return conversions;
    }

}
