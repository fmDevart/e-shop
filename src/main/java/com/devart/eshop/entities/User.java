package com.devart.eshop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {


    public User(){
        this.cart = new Cart();
    }
    public User(String username, String password) {
        super();

        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue
    Long id;

    String username;
    String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    Cart cart ;


}
