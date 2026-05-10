package com.scaler.productservice.services;

import com.scaler.productservice.dtos.SortParam;
import com.scaler.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {


    Page<Product> search(String query, int pageNumber,
                         int pageSize, List<SortParam> sortParamList);
}
