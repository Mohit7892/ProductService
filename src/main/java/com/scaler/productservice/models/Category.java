package com.scaler.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//Categories class --> categories table in DB
@Entity(name="categories")
public class Category extends BaseModel {

    private String title;

    //name of the entity on products table
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> productList;
}
