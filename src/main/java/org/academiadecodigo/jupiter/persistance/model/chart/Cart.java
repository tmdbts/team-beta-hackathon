package org.academiadecodigo.jupiter.persistance.model.chart;

import org.academiadecodigo.jupiter.persistance.model.AbstractModel;
import org.academiadecodigo.jupiter.persistance.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cart extends AbstractModel {

    @ManyToOne
    private User user;

    @OneToMany
    private List<Order> orders;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {

        orders.add(order);
        order.setCart(this);
    }

    public void removeOrder(Order order) {

        orders.remove(order);
        order.setCart(null);
    }

    public double getTotalPrice() {

        double chartPrice = 0;

        for (Order o : orders) {
            chartPrice += o.getPrice();
        }

        return chartPrice;
    }
}
