package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.model.chart.Order;

import java.util.List;

public interface OrderService {

    //add Order
    Order addOrder(Order order);

    //get order by id
    Order getOrder(Integer id);

    //delete order
    void deleteOrder(Integer id) throws AssociationExistsException, OrderNotFoundException;

    //update order
    Order updateOrder (Integer id);

    //list orders
    List<Order> listOrders();


}
