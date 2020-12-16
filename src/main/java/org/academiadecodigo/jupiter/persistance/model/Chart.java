package org.academiadecodigo.jupiter.persistance.model;

import javax.persistence.*;

@Entity
@Table(name = "chart")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Chart extends AbstractModel {

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
