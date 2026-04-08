package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservice.exceptions.BadCreateProductRequestException;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //1. Get a Product--localhost::8080/products/2
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId) throws ProductNotFoundException {
        if(productId <= 0){
            throw new IllegalArgumentException("Invalid product id used");
        }
        //Either handle the exception or throw as it is
        Product product = productService.getProductById(productId);

        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    //2. Get all products --localhost::8080/products
    @GetMapping("")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) throws BadCreateProductRequestException {
       //Handle the exception or throw it as it is
        Product product = productService.createProduct(createProductRequestDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

/*    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e){
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setProductId(e.getProductId());
        dto.setMessage(e.getMessage());

        return new ResponseEntity<>(
                dto,HttpStatus.NOT_FOUND);
    }*/
}
