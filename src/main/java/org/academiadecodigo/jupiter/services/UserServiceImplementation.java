package org.academiadecodigo.jupiter.services;

import org.academiadecodigo.jupiter.persistance.dao.OrderDao;
import org.academiadecodigo.jupiter.persistance.dao.UserDao;
import org.academiadecodigo.jupiter.persistance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private UserDao userDao;
    private OrderDao orderDao;

@Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


@Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public User getUser(Integer id) {

        return User;
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
