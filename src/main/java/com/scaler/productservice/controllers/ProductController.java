package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId){
        if(productId <= 0){
            throw new IllegalArgumentException("Invalid product id used");
        }
        Product product = productService.getProductById(productId);
        if(product == null)
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    //2. Get all products --localhost::8080/products
    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
