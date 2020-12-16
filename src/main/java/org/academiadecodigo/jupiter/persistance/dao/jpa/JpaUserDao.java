package org.academiadecodigo.jupiter.persistance.dao.jpa;


public class JpaUserDao extends GenericJpaDao<User> implements UserDao{

    public JpaUserDao(){
        super(User.class);
    }

}
