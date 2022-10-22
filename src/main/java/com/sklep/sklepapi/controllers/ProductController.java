package com.sklep.sklepapi.controllers;

import com.sklep.sklepapi.models.Product;
import com.sklep.sklepapi.models.User;
import com.sklep.sklepapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("products")
    public List<Product> showProducts(){
        return productRepository.getProducts();



    }
    @GetMapping("products/{id}")
    public Product showProductById(@PathVariable("id") int id){
        return productRepository.getProductById(id);

    }
    @PostMapping("products/add")
    public int addProduct(@RequestBody List<Product> products){
        return productRepository.addProduct(products);
    }
    @PutMapping("products/updateput/{id}")
    public String putProduct(@PathVariable int id,@RequestBody Product updatedProduct) {
        Product oldProduct = productRepository.getProductById(id);
        if(oldProduct != null) {
            updatedProduct.setId(oldProduct.getId());
            return productRepository.putProduct(updatedProduct) == 1 ? "OK" : "ERROR";
        }
        return "Nie istnieje";
    }
    @PatchMapping("products/updatepatch/{id}")
    public String patchUser(@PathVariable int id, @RequestBody Product updatedProduct){
        Product oldProduct = productRepository.getProductById(id);
        if(oldProduct != null) {
            updatedProduct.setId(oldProduct.getId());
            if (updatedProduct.getName() != null){
                updatedProduct.setName(oldProduct.getName());
            }
            if (updatedProduct.getPrice() != 0){
                updatedProduct.setPrice(oldProduct.getPrice());
            }
            if (updatedProduct.getCategory() != 0){
                updatedProduct.setCategory(oldProduct.getCategory());
            }
            if (updatedProduct.getDescribe() != null){
                updatedProduct.setDescribe(oldProduct.getDescribe());
            }
            return productRepository.patchProduct(updatedProduct) == 1 ? "OK" : "ERROR";
        }
        return "Nie istnieje";
    }
}
