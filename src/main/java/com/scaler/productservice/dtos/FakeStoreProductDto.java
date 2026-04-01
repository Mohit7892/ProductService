package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long Id;
    private String title;
    private double price;
    private String description;
    private String imageUrl;
    private String category;

    public static Product getProductFrom(FakeStoreProductDto fakeStoreProductDto ){
        Product product = null;
        if(fakeStoreProductDto != null){
            product = new Product();
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
        return product;
    }
}
