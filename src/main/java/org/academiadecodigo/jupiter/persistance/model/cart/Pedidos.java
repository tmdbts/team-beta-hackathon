package org.academiadecodigo.jupiter.persistance.model.cart;

import org.academiadecodigo.jupiter.persistance.model.AbstractModel;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidos")
public class Pedidos extends AbstractModel implements Serializable {

    @EmbeddedId
    private OrderKey key;

    private int quantity = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    private Cart cart;

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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets the price of the recipe for the quantity chosen by the user
     *
     * @return the price of the recipe for the quantity chosen by the user
     */
    public double getPrice() {
        return recipe.getRecipePrice() * quantity;
    }
}
