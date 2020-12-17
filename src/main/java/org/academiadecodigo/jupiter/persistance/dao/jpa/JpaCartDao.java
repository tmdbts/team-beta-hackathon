package org.academiadecodigo.jupiter.persistance.dao.jpa;

import org.academiadecodigo.jupiter.persistance.dao.CartDao;
import org.academiadecodigo.jupiter.persistance.model.chart.Cart;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaCartDao extends GenericJpaDao<Cart> implements CartDao {

    public JpaCartDao(){
        super(Cart.class);
    }

    public List<Cart> getUserCart(Integer id) {

        TypedQuery<Cart> query = em.createQuery("SELECT DISTINCT cart FROM Cart cart JOIN cart.id t WHERE t = :id", Cart.class);

        query.setParameter("id", id);

        return query.getResultList();
    }


}
