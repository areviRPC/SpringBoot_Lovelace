package com.riwi.products.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data // crea getter y selects junto con toString()
@AllArgsConstructor // crea Constructor lleno
@NoArgsConstructor // crea constructor vacio 
public class Products {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private int quantity;

    private double price;
    
}
