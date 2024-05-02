package com.riwi.operations.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greet") // esta ruta especifica la version en la que estamos trabajando
public class HelloController {
    
    @GetMapping 
    public String greet(){
        return "Hola mundo";
    }

}
