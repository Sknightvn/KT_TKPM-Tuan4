package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getProduct();

    void updateProduct(String id, Product product);

    void deleteProduct(String id);
}
