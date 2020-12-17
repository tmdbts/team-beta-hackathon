package org.academiadecodigo.jupiter.persistance.model.chart;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderKey implements Serializable {

    private Integer cartId;

    private Integer recipeId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer chartId) {
        this.cartId = chartId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OrderKey that = (OrderKey) o;

        return Objects.equals(cartId, that.cartId) &&
                Objects.equals(recipeId, that.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, recipeId);
    }
}
