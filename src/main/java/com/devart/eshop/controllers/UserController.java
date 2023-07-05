package com.devart.eshop.controllers;

import com.devart.eshop.dto.AuthenticationRequest;
import com.devart.eshop.dto.AuthenticationResponse;
import com.devart.eshop.dto.RegisterRequest;
import com.devart.eshop.entities.User;
import com.devart.eshop.repositories.UserRepository;
import com.devart.eshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        System.out.println("ricevuto");

        return userRepository.findAll();

    }

    // @PostMapping("/addUser")
    // public ResponseEntity<User> createUser(@RequestBody UserCreateUpdateDto newUser) {

    //     User user = new User(newUser.getUsername(), newUser.getPassword());

    //     userRepository.save(user);
    //     return ResponseEntity.ok(user);

    // }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {


        return ResponseEntity.ok(userService.authenticateUser(request));


    }


    @PostMapping("/auth/register")
    public ResponseEntity<AuthenticationResponse> register( @RequestBody RegisterRequest request){

        return ResponseEntity.ok(userService.registerUser(request));
    }


}


