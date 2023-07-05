package com.devart.eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devart.eshop.entities.Role;


public interface RoleRepository  extends JpaRepository< Role,Long > {

    Role findByName(String name);
    
}
