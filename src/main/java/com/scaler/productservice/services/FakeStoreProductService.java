package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.exceptions.BadCreateProductRequestException;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import static com.scaler.productservice.dtos.FakeStoreProductDto.*;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
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
    public Product createProduct(CreateProductRequestDto createProductRequestDto) throws BadCreateProductRequestException {
        //we communicate to FS API via FakeStoreProductDto.
        FakeStoreProductDto createProductDto = new FakeStoreProductDto();
        createProductDto.setTitle(createProductRequestDto.getTitle());
        createProductDto.setPrice(createProductRequestDto.getPrice());
        createProductDto.setDescription(createProductRequestDto.getDescription());
        createProductDto.setImageUrl(createProductRequestDto.getImageUrl());
        createProductDto.setCategory(createProductDto.getCategory());

        //call the api
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity("https://fakestoreapi.com/products",
                createProductDto,FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null)
            throw new BadCreateProductRequestException("Request body is invalid!!");
        return getProductFrom(fakeStoreProductDto);
    }

    @Override
    public Product updateProduct(long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(long productId) {
        return false;
    }
}
