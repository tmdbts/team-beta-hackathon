package org.academiadecodigo.jupiter.persistance.dao.jpa;

import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao extends GenericJpaDao<User> implements UserDao{

    public JpaUserDao(){
        super(User.class);
    }

}