package com.devart.eshop.controllers;

import com.devart.eshop.dto.LoginDto;
import com.devart.eshop.dto.UserCreateUpdateDto;
import com.devart.eshop.entities.User;
import com.devart.eshop.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        System.out.println("ricevuto");

        return userRepository.findAll();

    }

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody UserCreateUpdateDto newUser) {

        User user = new User(newUser.getUsername(), newUser.getPassword());

        userRepository.save(user);
        return ResponseEntity.ok(user);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginData) {
        try {
            User userTarget = userRepository.findByUsername(loginData.getUsername()).orElseThrow(() -> new EntityNotFoundException());
            if(!userTarget.getPassword().equals(loginData.getPassword())){
                throw new Exception("wrong credential!");
            }
            return new ResponseEntity<String>("login success", HttpStatus.OK);

        } catch (EntityNotFoundException e ) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e ){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);

        }


    }

}


