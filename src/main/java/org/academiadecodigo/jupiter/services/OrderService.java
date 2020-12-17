package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.cart.Pedidos;

import java.util.List;

public interface OrderService {

    //add Order
    Pedidos addOrder(Pedidos pedidos);

    //get order by id
    Pedidos getOrder(Integer id);

    //delete order
    void deleteOrder(Integer id); //throws AssociationExistsException, OrderNotFoundException;

    //update order
    Pedidos updateOrder(Integer id);

    //list orders
    List<Pedidos> listOrders();
}
