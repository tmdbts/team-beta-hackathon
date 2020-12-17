package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.dao.OrderDao;
import org.academiadecodigo.jupiter.persistance.model.chart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderServiceImplementation implements OrderService {

    private OrderDao orderDao;

    @Autowired
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
    public void deleteOrder(Integer id) {
    } // throws AssociationExistsException, OrderNotFoundException

    @Override
    public Order updateOrder(Integer id) {

        return null;
    }

    @Override
    public List<Order> listOrders() {

        return null;
    }
}
