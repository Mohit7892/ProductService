package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    void findTitleByOrderByIdDesc() {
       List<String> productTitles = productRepository.findTitleByOrderByIdDesc();
        productTitles.forEach(System.out::println);
    }
}