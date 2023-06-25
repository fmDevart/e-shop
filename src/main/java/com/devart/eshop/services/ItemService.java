package com.devart.eshop.services;

import com.devart.eshop.dto.ItemCreateUpdateDto;
import com.devart.eshop.entities.Item;
import com.devart.eshop.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    final private ItemRepository itemRepository;

    public Item createItem(ItemCreateUpdateDto newItem){

       return  this.itemRepository.save(new Item(newItem));

    }

    public Item getItemById( long id){

        return this.itemRepository.findById(id);

    }

    public List<Item> getItems( ){

        return this.itemRepository.findAll();

    }


}
