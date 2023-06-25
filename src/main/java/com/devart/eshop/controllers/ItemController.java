package com.devart.eshop.controllers;


import com.devart.eshop.dto.ItemCreateUpdateDto;
import com.devart.eshop.entities.Item;
import com.devart.eshop.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems(){
            return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK );
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id){

            return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody ItemCreateUpdateDto newItem){
        return new ResponseEntity<>(itemService.createItem(newItem), HttpStatus.OK);
    }

}
