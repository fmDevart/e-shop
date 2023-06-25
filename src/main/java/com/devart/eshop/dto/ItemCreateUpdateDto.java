package com.devart.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreateUpdateDto {
    String name;
    String description;
    float price;
    int amount;
}
