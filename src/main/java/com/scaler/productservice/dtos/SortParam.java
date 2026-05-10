package com.scaler.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParam {

    private String sortBy;
    private SortDirection sortDirection;
}
