package com.devart.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel extends RepresentationModel<ItemModel> {
    Long id;
    String name;
    String description;
    float price;
    int amount;
}
