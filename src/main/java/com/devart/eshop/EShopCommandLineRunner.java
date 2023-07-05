package com.devart.eshop;

import com.devart.eshop.entities.User;
import com.devart.eshop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EShopCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("*** save admin user ****");
        if( userRepository.findAll().isEmpty()){
            userRepository.save( new User("Admin","Admin","admin@admin.com"));

        }
    }
}
