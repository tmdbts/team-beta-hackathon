package org.academiadecodigo.jupiter.services;

import javax.swing.plaf.UIResource;
import java.util.List;

public class UserServiceImplementation implements UserService {

    private UserDao userDao;
    private OrderDao orderDao;


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public User getUser(Integer id) {

        return null;
    }

    @Override
    public List<Order> getUserOrders(Integer id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) throws AssociationExistsException, UserNotFoundException {

    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}
