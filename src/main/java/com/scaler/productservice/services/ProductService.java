package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(long productId, Product product);
    void deleteProduct(long productId);
}
