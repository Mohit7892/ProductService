package com.scaler.productservice.dtos;


import com.scaler.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
