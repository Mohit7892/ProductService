package com.scaler.productservice.controllers;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.models.State;
import com.scaler.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean(name = "storageProductService")
    private ProductService productService;


    @Test
    @Transactional
    void testGetProductById_usingPositiveValue() throws ProductNotFoundException {
        //Arrange
        //since we mocked product service, we need to define what product service
        //method getProductbyid will return whenever called

        Product product = new Product();
        product.setId(10L);
        product.setTitle("testTitle");
        product.setDescription("testDescription");
        product.setPrice(10.10);
        product.setState(State.ACTIVE);

        Category category = new Category();
        category.setTitle("testCategory");
        category.setState(State.INACTIVE);

        product.setCategory(category);
        //define product service behavior
        when(productService.getProductById(10L)).thenReturn(product);

        //Act
        ResponseEntity<Product> outputProductEnity = productController.
                getProduct(10L);
        Product outputProduct = outputProductEnity.getBody();

        //Assert
        assertNotNull(outputProductEnity);
        assertNotNull(outputProduct);
        assertEquals(10L,outputProduct.getId());
        assertEquals(10.10, outputProduct.getPrice());
        verify(productService, times(1)).getProductById(10L);
    }

    @Test
    @Transactional
    void test_getProductById_usingNegativeProductId(){
        //there is no need to mock the service dependency, as code will not reach there
        //it will throw an exception with a -ve product id
        assertThrows(IllegalArgumentException.class,() -> productController.getProduct(-1L));
    }

    @Test
    @Transactional
    void test_getProductById_usingInvalidProductId() throws ProductNotFoundException {
        //Arrange

        //Act
      Exception e = assertThrows(IllegalArgumentException.class,
              () -> productController.getProduct(0L));
      assertEquals("Invalid product id used",e.getMessage());
      verify(productService,times(0)).getProductById(0L);
    }
}