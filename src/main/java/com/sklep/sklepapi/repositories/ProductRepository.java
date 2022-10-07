package com.sklep.sklepapi.repositories;

import com.sklep.sklepapi.models.Product;
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

}
