package com.devart.eshop.entities;

import com.devart.eshop.dto.ItemCreateUpdateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Item {

    public Item(String name, String description, float price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Item(ItemCreateUpdateDto newItem) {
        this.name = newItem.getName();
        this.description = newItem.getDescription();
        this.price = newItem.getPrice();
        this.amount = newItem.getAmount();


    }


    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    float price;
    int amount;



}
