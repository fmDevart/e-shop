package com.devart.eshop.repositories;

import com.devart.eshop.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findById(long id);

    Page<Item> findAll(Pageable pageable);
}
