package com.scaler.productservice.controllers;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping("/getCategoryMessage")
    public String getCategoryMessage() throws ProductNotFoundException {
        throw new ProductNotFoundException("Product id passed is invalid",10L);
    }

    //Should I repeat the same exception handler code written in ProductController
    //DRY principal violated --> Move exception handlers to common place --> controlleradvice
}
