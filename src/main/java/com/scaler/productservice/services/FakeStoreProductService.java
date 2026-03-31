package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements  ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(long productId) {
       ResponseEntity<FakeStoreProductDto> responseEntity =
               restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDto.class
        );
        return convertFakeStoreDtoToProduct(responseEntity.getBody());
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long productId) {

    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        if(fakeStoreProductDto != null){
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImageUrl(fakeStoreProductDto.getImageUrl());

            Category category = new Category();
            category.setTitle(fakeStoreProductDto.getCategory());

            product.setCategory(category);
            return product;
        }
        return null;
    }
}
