package com.sklep.sklepapi.repositories;

import com.sklep.sklepapi.models.Product;
import com.sklep.sklepapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
     JdbcTemplate jdbcTemplate;

    public List<Product> getProducts() {
        return
                jdbcTemplate.query(
                        "SELECT * FROM product",
                        BeanPropertyRowMapper.newInstance(Product.class)
                );

    }

    public Product getProductById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM product WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Product.class)
        );
    }

    public int addProduct(List<Product> products) {
        int rows =0;
        for (Product product : products) {
            rows+= jdbcTemplate.update("INSERT INTO product VALUES(NULL,?,?,?,?)",
                    product.getName(),
                    product.getPrice(),
                    product.getCategory(),
                    product.getDescribe());
        }
        return 1;
    }

    public int putProduct(Product product) {
        return jdbcTemplate.update("UPDATE product SET name =?, price=?, category=?,describe=? WHERE id =?",
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.getDescribe(),
                product.getId());

    }

    public int patchProduct(Product product) {
        return jdbcTemplate.update("UPDATE product SET name =?, price=?, category=?, describe=? WHERE id =?",
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.getDescribe(),
                product.getId());
    }
}
