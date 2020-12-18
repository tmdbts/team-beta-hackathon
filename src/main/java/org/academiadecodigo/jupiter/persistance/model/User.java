package org.academiadecodigo.jupiter.persistance.model;


import org.academiadecodigo.jupiter.persistance.model.cart.Cart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "user",
            fetch = FetchType.EAGER
    )
    private List<Cart> cartList = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void addToCartList(Cart cart) {

        cartList.add(cart);
        cart.setUser(this);
    }

    public void removeFromCartList(Cart cart) {

        cartList.remove(cart);
        cart.setUser(null);
    }
}
