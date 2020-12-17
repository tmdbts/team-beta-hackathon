package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.dao.CartDao;
import org.academiadecodigo.jupiter.persistance.dao.UserDao;
import org.academiadecodigo.jupiter.persistance.model.User;
import org.academiadecodigo.jupiter.persistance.model.cart.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImplementation implements UserService {

    private UserDao userDao;
    private CartDao cartDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public CartDao getCartDao() {
        return cartDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.findById(id);
    }

    //TODO : I AM LOST BETWEEN CART AND ORDERS
    @Override
    public List<Pedidos> getUserOrders(Integer id) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }//throws AssociationExistsException, UserNotFoundException {

    @Override
    public List<User> listUsers() {
        return userDao.findAll();
    }
}