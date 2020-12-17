package org.academiadecodigo.jupiter.persistance.model.recipe;

import org.academiadecodigo.jupiter.persistance.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient extends AbstractModel {

    private double price = 0;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,  mappedBy = "ingredientList")
    private List<Recipe> recipesList;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipesList;
    }

    public void addRecipe(Recipe recipe) {
        recipesList.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipesList.remove(recipe);
    }

    @Override
    public String toString() {
        return name;
    }
}
