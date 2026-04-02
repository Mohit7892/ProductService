package com.scaler.productservice.controlleradvices;

import com.scaler.productservice.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Global Exception Handler class
@RestControllerAdvice
public class ControllerAdvice {

    //Handle ProductNotFound exception across controllers
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e){
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setProductId(e.getProductId());
        dto.setMessage(e.getMessage());

        return new ResponseEntity<>(
                dto, HttpStatus.NOT_FOUND);
    }

    //we can add multiple exception handlers which are common across controllers
    //Though unique exceptions to a controller, should be handled inside that
    //controller class only.
}
