package org.academiadecodigo.jupiter.services;

import java.util.List;

public interface UserService {

        //Get user by id
        User getUser(Integer id);

        //get user orders by using userId
        List<Order> getUserOrders(Integer id); // throws UserNotFoundException;

        //save user
        User saveUser(User user);

       //delete user
        void deleteUser(Integer id); // throws AssociationExistsException, UserNotFoundException;

        //list users
        List<User> listUsers();

    }

