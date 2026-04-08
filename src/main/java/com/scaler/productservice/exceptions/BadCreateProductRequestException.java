package com.scaler.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadCreateProductRequestException extends Exception {
    private String message;

    public BadCreateProductRequestException(String message){
        super(message);
        this.message = message;
    }
}
