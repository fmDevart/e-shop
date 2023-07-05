package com.devart.eshop.services;

import org.aspectj.weaver.bcel.AtAjAttributes;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devart.eshop.dto.AuthenticationRequest;
import com.devart.eshop.dto.AuthenticationResponse;
import com.devart.eshop.dto.RegisterRequest;
import com.devart.eshop.entities.Role;
import com.devart.eshop.entities.User;
import com.devart.eshop.repositories.RoleRepository;
import com.devart.eshop.repositories.UserRepository;
import com.devart.eshop.security.JwtService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public User saveUser(User user) {

        return userRepository.save(user);

    }

    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found id: " + id));
        userRepository.delete(user);
    }

    public void addRoleToUser(long id, String role) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found id: " + id));
        Role roleTarget = roleRepository.findByName(role);

        user.getRoles().add(roleTarget);
        userRepository.save(user);

    }

    public  AuthenticationResponse registerUser( RegisterRequest registerRequest ){

        User user = new User( registerRequest.getName(), passwordEncoder.encode(registerRequest.getPsw()),registerRequest.getEmail());
    
        String jwtToken = jwtService.generateToken(userRepository.save(user));
        return new AuthenticationResponse(jwtToken);
        



    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPsw())
        );

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new EntityNotFoundException("user not foudn"));

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
        

    }

}
