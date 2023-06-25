package com.devart.eshop.repositories;

import com.devart.eshop.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

    public Item findById(long id);
}
