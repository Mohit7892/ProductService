package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //@Autowired
    private ProductService productService;

    public ProductController(ProductService productService){

        this.productService = productService;
    }

    //localhost::8080/products/getWelcomeMsg ---> ProductController -> getWelcomeMsg()
    @GetMapping("/getWelcomeMsg")
    public String getWelcomeMsg(){
        return "Welcome to sprint boot web project";
    }

    //Implement Get product Apis
    //1. Get a Product--localhost::8080/products/22
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") long productId){
        return productService.getProductById(productId);
    }

    //2. Get all products --localhost::8080/products
    @GetMapping("")
    public List<Product> getAllProducts(){
        return  null;
    }
}
