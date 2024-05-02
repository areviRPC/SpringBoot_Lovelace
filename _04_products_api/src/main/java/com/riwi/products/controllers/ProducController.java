package com.riwi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entities.Products;
import com.riwi.products.services.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor // 
public class ProducController {
    
    @Autowired 
    private final IProductService objIProductService; // palabara reservada final es una forma de instanciar a prodcut

    @GetMapping
    public ResponseEntity<List<Products>> getAll(){
        return ResponseEntity.ok(this.objIProductService.getAll());
    }

    @GetMapping(path = "/{id}") // 1
    public ResponseEntity<Products> get(@PathVariable Long id){
        return ResponseEntity.ok(this.objIProductService.getById(id)) ;
    }

    @PostMapping
    public ResponseEntity<Products> insert(
        @RequestBody Products objProducts
    ){
        return ResponseEntity.ok(this.objIProductService.save(objProducts));  // Repsonse entity 
    }


    @PutMapping(path = "/{id}") // 2
    public ResponseEntity<Products> update(@RequestBody Products objProducts,@PathVariable Long id){
        objProducts.setId(id);
        return ResponseEntity.ok(this.objIProductService.update(objProducts));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete( @PathVariable Long id) {
        this.objIProductService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
