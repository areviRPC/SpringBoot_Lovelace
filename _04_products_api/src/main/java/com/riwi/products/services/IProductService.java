package com.riwi.products.services;

import java.util.List;

import com.riwi.products.entities.Products;


// usamos una interfaz para ser utilizada como inyeccion de dependencias 
// en el controlador, esto mantiene integridadm desacoplamiento y 
// principios SOLID 


public interface IProductService {

    public Products save(Products objProducts);

    public List<Products> getAll();
    
    public Products getById(Long id);

    public void delete(Long id);

    public Products update(Products objProducts); 

    // SroingbootApp.bind(IProductService, ProductService)
}
