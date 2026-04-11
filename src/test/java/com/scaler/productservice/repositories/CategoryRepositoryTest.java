package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    void testFetchTypes() {
        /*Optional<Category> optionalCategory =
                categoryRepository.findById(2L);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            System.out.println(category.getTitle());
            //System.out.println(category.getProductList().size());
        }*/

        List<Category> categories = categoryRepository.findAll();
        System.out.println("No. of cat. found are:"+categories.size());
        for(Category cat : categories){
            System.out.println("The category is :"+cat.getTitle());
            System.out.println("The no. of products in this cat is :"+
                    cat.getProductList().size());
        }
    }
}