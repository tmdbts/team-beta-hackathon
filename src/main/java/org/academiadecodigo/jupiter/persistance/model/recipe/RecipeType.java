package org.academiadecodigo.jupiter.persistance.model.recipe;


import org.academiadecodigo.jupiter.persistance.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "recipe_type")
public class RecipeType extends AbstractModel {

    private String type;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Recipe> recipeList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

}
