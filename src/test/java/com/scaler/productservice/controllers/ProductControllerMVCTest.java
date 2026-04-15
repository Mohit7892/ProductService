package com.scaler.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.models.State;
import com.scaler.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerMVCTest {

    @Autowired
    private ProductController productController;

    @MockitoBean(value = "storageProductService")
    private ProductService productService;

    //to simulate the trigger of http methods
    @Autowired
    private MockMvc mockMvc;

    //for Json handling
    @Autowired
    private ObjectMapper objectMapper;

    //here we directly call the controller endpoints
    @Test
    void getAllProducts_successOk() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk());
    }

    @Test
    void getAllProducts_ResultOk() throws Exception {
        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("test title1");
        p1.setDescription("test description1");
        p1.setPrice(23.23);
        p1.setState(State.ACTIVE);

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("test title2");
        p2.setDescription("test description2");
        p2.setPrice(24.24);
        p2.setState(State.ACTIVE);

        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);

        //defined the mock behavior
        when(productService.getAllProducts()).thenReturn(productList);

        //convert product list into json
        String expectedJson = objectMapper.writeValueAsString(productList);
        System.out.println(productList);

        //Act
        mockMvc.perform(get("/products")).andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedJson))
                .andExpect(jsonPath("$[0].title").value("test title1"));
    }

    @Test
    void test_createProduct_successCreated() throws Exception {
        //Arrange
        //Stub the createProduct method of the mock i.e. product service
        CreateProductRequestDto requestDto = new CreateProductRequestDto();
        requestDto.setTitle("test title9");
        requestDto.setDescription("test description9");
        requestDto.setImageUrl("http://images9");
        requestDto.setPrice(99.99);

        String requestJson = objectMapper.writeValueAsString(requestDto);

        Product product = new Product();
        product.setId(9L);
        product.setTitle("test title9");
        product.setDescription("test description9");
        product.setImageUrl("http://images9");
        product.setPrice(99.99);

        String responseJson = objectMapper.writeValueAsString(product);

        //define the behavior of your mock
        when(productService.createProduct(any(CreateProductRequestDto.class)))
                .thenReturn(product);

        //act
        mockMvc.perform(post("/products")
                .content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(responseJson))
                .andExpect(jsonPath("$.title").value("test title9"));
        System.out.println(responseJson);
    }
}