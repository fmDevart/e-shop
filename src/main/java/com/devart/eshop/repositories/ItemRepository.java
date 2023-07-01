package com.devart.eshop.repositories;

import com.devart.eshop.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    Item findById(long id);

    Page<Item> findAll(Pageable pageable);

    public List<Item> findAll();

    Item save(Item item);
}
