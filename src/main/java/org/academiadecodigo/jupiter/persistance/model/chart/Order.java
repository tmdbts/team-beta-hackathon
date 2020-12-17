package org.academiadecodigo.jupiter.persistance.model.chart;

import org.academiadecodigo.jupiter.persistance.model.AbstractModel;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order extends AbstractModel {

    @EmbeddedId
    private OrderKey key;

    private int quantity = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("chartId")
    private Chart chart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipeId")
    private Recipe recipe;

    public OrderKey getKey() {
        return key;
    }

    public void setKey(OrderKey key) {
        this.key = key;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    //Returns the price of the recipe for the quantity chosen by the user
    public double getPrice() {
        return recipe.getRecipePrice() * quantity;
    }

}
