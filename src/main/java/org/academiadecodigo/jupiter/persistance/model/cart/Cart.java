package org.academiadecodigo.jupiter.persistance.model.cart;

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
    private List<Pedidos> pedidos;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Pedidos> getOrders() {
        return pedidos;
    }

    public void addOrder(Pedidos pedidos) {

        this.pedidos.add(pedidos);
        pedidos.setCart(this);
    }

    public void removeOrder(Pedidos pedidos) {

        this.pedidos.remove(pedidos);
        pedidos.setCart(null);
    }

    public double getTotalPrice() {

        double cartPrice = 0;

        for (Pedidos o : pedidos) {
            cartPrice += o.getPrice();
        }

        return cartPrice;
    }
}
