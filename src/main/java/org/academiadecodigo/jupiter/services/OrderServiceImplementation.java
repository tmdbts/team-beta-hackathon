package org.academiadecodigo.jupiter.services;

import java.util.List;

public class OrderServiceImplementation implements OrderService{

    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrder(Integer id) {
        return null;
    }

    @Override
    public void deleteOrder(Integer id) throws AssociationExistsException, OrderNotFoundException {

    }

    @Override
    public Order updateOrder(Integer id) {
        return null;
    }

    @Override
    public List<Order> listOrders() {
        return null;
    }
}
