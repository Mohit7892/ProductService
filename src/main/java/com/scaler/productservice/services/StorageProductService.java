package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.exceptions.BadCreateProductRequestException;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.models.State;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("storageProductService")
//@Primary
public class StorageProductService implements ProductService {

    private final ProductRepository productRepository;

    public StorageProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(CreateProductRequestDto createProductRequestDto) throws BadCreateProductRequestException {
        Product newProduct = new Product();
        newProduct.setTitle(createProductRequestDto.getTitle());
        newProduct.setDescription(createProductRequestDto.getDescription());
        newProduct.setPrice(createProductRequestDto.getPrice());
        newProduct.setImageUrl(createProductRequestDto.getImageUrl());

        Category newCategory = new Category();
        newCategory.setTitle(createProductRequestDto.getCategory().getTitle());

        newProduct.setCategory(newCategory);
       return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(long productId, Product product) {
       Optional<Product> productOptional = productRepository.findById(productId);
       if(productOptional.isPresent()){
           product.setId(productId);
           product.setQuantity(4);
           product.setState(State.ACTIVE);
           Category updateCategory = product.getCategory();
           updateCategory.setState(State.ACTIVE);
           product.setCategory(updateCategory);
           return productRepository.save(product);
       }
        return null;
    }

    @Override
    public boolean deleteProduct(long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            if(product.getState().equals(State.ACTIVE)){ // do safe delete
                product.setState(State.INACTIVE);
                product.setLastUpdatedAt(new Date());
                productRepository.save(product);
            }
            else // do actual delete - if already INACTIVE
                productRepository.deleteById(productId);
            return true;
        }
        else //if product id is not present
            return false;
    }
}
