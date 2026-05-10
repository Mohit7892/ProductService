package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.SearchRequestDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestDto searchRequestDto){
        //pageNumber -> offset
        //pagesize -> limit
        return searchService.search(searchRequestDto.getQuery(),
                searchRequestDto.getPageNumber(),
                searchRequestDto.getPageSize(),
                searchRequestDto.getSortParamList());
    }
}
