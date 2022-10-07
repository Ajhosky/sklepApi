package com.sklep.sklepapi.controllers;

import com.sklep.sklepapi.models.Product;
import com.sklep.sklepapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> showProducts(){
        return productRepository.getProducts();

    }

}
