package org.academiadecodigo.jupiter.persistance.model.chart;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderKey implements Serializable {

    private Long chartId;

    private Long recipeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OrderKey that = (OrderKey) o;
        return Objects.equals(chartId, that.chartId) &&
                Objects.equals(recipeId, that.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chartId, recipeId);
    }

}
