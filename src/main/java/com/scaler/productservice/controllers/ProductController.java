package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    //localhost::8080/products/getWelcomeMsg ---> ProductController -> getWelcomeMsg()
    @GetMapping("/getWelcomeMsg")
    public String getWelcomeMsg(){
        return "Welcome to sprint boot web project";
    }
}
