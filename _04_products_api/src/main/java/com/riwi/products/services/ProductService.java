package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Products;
import com.riwi.products.repositories.PorductoRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor 
public class ProductService implements IProductService{ // esto establece la conexion entre ambas partes

    @Autowired
    private final PorductoRepository objPorductoRepository; // final es una manera de instanciar product repository. Esto significa que objRepository es estatico por lo que lo inicializamos con el @allString al inicio
    
    
    @Override // Metodo save que permite actualizar y crear productos
    public Products save(Products objProducts) { // recibe un objeto producto
        return this.objPorductoRepository.save(objProducts) ;
    } 

    @Override
    public List<Products> getAll() {
        return this.objPorductoRepository.findAll();
    }

    @Override // 1
    public Products getById(Long id) {
        return this.objPorductoRepository.findById(id).orElseThrow(); 
    }

    @Override // 3
    public void delete(Long id) {
        Products producto = this.objPorductoRepository.findById(id).orElseThrow();
    
        this.objPorductoRepository.delete(producto);
    }   

    @Override // 2 
    public Products update(Products objProducts) {
        return  this.objPorductoRepository.save(objProducts);
    }
}
