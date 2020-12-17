package org.academiadecodigo.jupiter.persistance.dao.jpa;

import org.academiadecodigo.jupiter.persistance.dao.OrderDao;
import org.academiadecodigo.jupiter.persistance.model.cart.Pedidos;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderDao extends GenericJpaDao<Pedidos> implements OrderDao {

    public JpaOrderDao() {
        super(Pedidos.class);
    }
}