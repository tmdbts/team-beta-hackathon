package org.academiadecodigo.jupiter.controllers.assembler;

import org.academiadecodigo.jupiter.persistance.model.recipe.Ingredient;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;
import org.academiadecodigo.jupiter.persistance.model.recipe.RecipeType;
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
        recipeDto.setTypes(generateStringType(recipe.getTypes()));
      //  recipeDto.setIngredients(generateString(recipe.getIngredientList()));

        return recipeDto;
    }

    public List<org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto> convert(List<Recipe> list) {

        List<org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto> conversions = new ArrayList<>(list.size());

        for (Recipe toConvert : list) {
            conversions.add(convert(toConvert));
        }

        return conversions;
    }

    private String generateString(List<Ingredient> ingredientsList){
        StringBuilder stringBuilder = new StringBuilder();
        for (Ingredient ingredient:ingredientsList){
            stringBuilder.append(ingredient.getName() + " ");
        }
        return stringBuilder.toString();
    }

    private String generateStringType(List<RecipeType> ingredientsList){
        StringBuilder stringBuilder = new StringBuilder();
        for (RecipeType ingredient:ingredientsList){
            stringBuilder.append(ingredient.getType() + " ");
        }
        return stringBuilder.toString();
    }


}
