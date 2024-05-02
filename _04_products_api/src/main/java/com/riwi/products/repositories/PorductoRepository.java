package com.riwi.products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.products.entities.Products;

@Repository
public interface PorductoRepository extends JpaRepository<Products, Long> { // recibe la entiedad y el Id

    public List<Products> findByName(String name);
    
}
