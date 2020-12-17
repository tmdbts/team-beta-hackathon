package org.academiadecodigo.jupiter.persistance.dao.jpa;

import org.academiadecodigo.jupiter.persistance.dao.OrderDao;
import org.academiadecodigo.jupiter.persistance.model.chart.Order;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderDao extends GenericJpaDao<Order> implements OrderDao {

    public JpaOrderDao() {
        super(Order.class);
    }
}