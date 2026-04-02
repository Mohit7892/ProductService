package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import static com.scaler.productservice.dtos.FakeStoreProductDto.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements  ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(long productId) throws ProductNotFoundException {
       ResponseEntity<FakeStoreProductDto> responseEntity =
               restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDto.class);
       FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
       if(fakeStoreProductDto == null){
           throw new ProductNotFoundException("The product id pass is invalid",
                   productId);
       }
        return getProductFrom(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity
                ("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : responseEntity.getBody()){
            products.add(getProductFrom(fakeStoreProductDto));
        }
        return products;
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
}
