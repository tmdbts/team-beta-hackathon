package org.academiadecodigo.jupiter.persistance.model.recipe;


import org.academiadecodigo.jupiter.persistance.model.AbstractModel;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe extends AbstractModel {

    private String name;
    private int cookingTime;
    private String description;
    private String photoUrl;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    private List<RecipeType> types;

    @ManyToMany
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Ingredient> ingredientList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photOUrl) {
        this.photoUrl = photOUrl;
    }

    public List<RecipeType> getTypes() {
        return types;
    }

    public void setTypes(List<RecipeType> types) {
        this.types = types;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    //Returns the price of the recipe for one person
    public double getRecipePrice() {
        double recipePrice = 0;
        for (Ingredient i : ingredientList) {
            recipePrice += i.getPrice();
        }
        return recipePrice;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "cookingTime=" + cookingTime +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", types=" + types +
                ", ingredientList=" + ingredientList +
                '}';
    }




}
