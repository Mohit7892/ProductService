package com.scaler.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Categories class --> categories table in DB
@Entity(name="categories")
public class Category extends BaseModel {

    private String title;
}
