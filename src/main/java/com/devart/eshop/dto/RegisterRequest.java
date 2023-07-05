package com.devart.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class RegisterRequest {


    private String name;
    private String psw;
    private String email;

    
}
