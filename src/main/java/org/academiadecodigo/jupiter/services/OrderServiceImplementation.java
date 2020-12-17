package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.dao.OrderDao;
import org.academiadecodigo.jupiter.persistance.model.chart.Order;

import java.util.List;

public class OrderServiceImplementation implements OrderService{

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public Order addOrder(Order order) {

    }

    @Override
    public Order getOrder(Integer id) {
        return null;
    }

    @Override
    public void deleteOrder(Integer id){} // throws AssociationExistsException, OrderNotFoundException

    @Override
    public Order updateOrder(Integer id) {
        return null;
    }

    @Override
    public List<Order> listOrders() {
        return null;
    }
}
