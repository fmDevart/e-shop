package com.devart.eshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Data
public class Cart {

    @Id
    @GeneratedValue
    Long id;

    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name="cart_items",
//            joinColumns = @JoinColumn(
//                    name="cart_id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name="item_id"
//            )
//    )

    @JoinColumn(name="product_id")
    Set<Item> items = new HashSet<>();


    @OneToOne(mappedBy = "cart")
    User user;


    public Cart() {
        this.items = new HashSet<>();
    }
}
