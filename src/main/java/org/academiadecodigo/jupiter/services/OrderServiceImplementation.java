package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.dao.OrderDao;
import org.academiadecodigo.jupiter.persistance.model.cart.Pedidos;
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
    public Pedidos addOrder(Pedidos pedidos) {
        return pedidos;
    }

    @Override
    public Pedidos getOrder(Integer id) {
        return null;
    }

    @Override
    public void deleteOrder(Integer id) {
    } // throws AssociationExistsException, OrderNotFoundException

    @Override
    public Pedidos updateOrder(Integer id) {
        return null;
    }

    @Override
    public List<Pedidos> listOrders() {
        return null;
    }
}