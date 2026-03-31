package com.scaler.productservice.dtos;

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
}
