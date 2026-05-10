package com.scaler.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchRequestDto {

    private String query;
    private int pageSize;
    private int pageNumber;
    private List<SortParam> sortParamList;
}
