package com.scaler.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Product class --> products table in DB
@Entity(name="products")
public class Product extends BaseModel {

    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private int quantity;
    @ManyToOne
    private Category category;
}
