package com.devart.eshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="users ")
@Data
public class User {

    public User(long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue
    long id;

    String username;
    String password;


}
