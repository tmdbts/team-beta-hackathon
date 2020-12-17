package org.academiadecodigo.jupiter.persistance.model.chart;

import org.academiadecodigo.jupiter.persistance.model.AbstractModel;
import org.academiadecodigo.jupiter.persistance.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "chart")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Chart extends AbstractModel {

    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
