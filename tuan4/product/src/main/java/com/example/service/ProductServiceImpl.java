package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(String id, Product product) {
        productRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "khong tim thay"));
        product.setId(id);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "khong tim thay"));
        productRepository.delete(product);
    }


}
