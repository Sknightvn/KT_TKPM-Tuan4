package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public String createProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "them Product thanh cong";
    }

    @GetMapping
    public List<Product> getProduct() { return productService.getProduct();}

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable String id, @RequestBody Product product){
        productService.updateProduct(id, product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}


