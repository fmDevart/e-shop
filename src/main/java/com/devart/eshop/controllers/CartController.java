package com.devart.eshop.controllers;

import com.devart.eshop.entities.Cart;
import com.devart.eshop.entities.Item;
import com.devart.eshop.entities.User;
import com.devart.eshop.repositories.CartRepository;
import com.devart.eshop.repositories.UserRepository;
import com.devart.eshop.services.ItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem/{userId}/{itemId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable long itemId, @PathVariable long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("user not found!"));
        Item item = itemService.getItemById(itemId);
        Cart cart;
        if (Objects.isNull(user.getCart())) {
            cart = new Cart();
            Set<Item> newSet = new HashSet<>();
            newSet.add(item);
            cart.setItems(newSet);
            user.setCart(cart);

        } else {

            cart = user.getCart();
            cart.getItems().add(item);
        }

        Cart saved = cartRepository.save(cart);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/all/{userId}")
    public ResponseEntity<Set<Item>> getAll(@PathVariable long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (!user.isEmpty()) {
            return ResponseEntity.ok(user.get().getCart().getItems());
        } else {
            return ResponseEntity.ok(new HashSet<Item>());
        }

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("user not found"));

        Cart target = user.getCart();
        if (Objects.nonNull(target))
            return ResponseEntity.ok(target);
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{cartId}/item/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart( @PathVariable long cartId, @PathVariable long itemId){

         Cart target =  cartRepository.findById(cartId).orElseThrow(()-> new EntityNotFoundException("cart not found"));
         Item targetItem = itemService.getItemById(itemId);
         target.getItems().remove(targetItem);
         return ResponseEntity.ok(cartRepository.save(target));


    }

}
