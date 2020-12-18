package org.academiadecodigo.jupiter.persistance.model.recipe;


import org.academiadecodigo.jupiter.persistance.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "type")
public class RecipeType extends AbstractModel {

    private String type;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "types")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeType that = (RecipeType) o;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
