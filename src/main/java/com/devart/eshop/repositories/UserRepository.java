package com.devart.eshop.repositories;

import com.devart.eshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    public Optional<User> findByUsername(String username);


}
