package org.academiadecodigo.jupiter.persistance.model.chart;

import org.academiadecodigo.jupiter.persistance.model.AbstractModel;
import org.academiadecodigo.jupiter.persistance.model.recipe.Recipe;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order extends AbstractModel {

    @EmbeddedId
    private OrderKey key;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("chartId")
    private Chart chart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipeId")
    private Recipe recipe;

}
