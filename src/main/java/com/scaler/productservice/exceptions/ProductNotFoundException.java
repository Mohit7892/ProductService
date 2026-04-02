package com.scaler.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{
    private long productId;
    private String message;

    public ProductNotFoundException(String message, long productId){
        super(message);
        this.message = message;
        this.productId = productId;
    }
}
