package com.scaler.productservice.services;

import com.scaler.productservice.dtos.SortDirection;
import com.scaler.productservice.dtos.SortParam;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements  ISearchService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> search(String query, int pageNumber,
                                int pageSize, List<SortParam> sortParamList) {
        //Create a sort object with first element from sort params
        Sort sort = null;

        if(sortParamList != null && !sortParamList.isEmpty()) {
            if (sortParamList.get(0).getSortDirection().equals(SortDirection.DESC)) {
                sort = Sort.by(sortParamList.get(0).getSortBy()).descending();
            } else
                sort = Sort.by(sortParamList.get(0).getSortBy()).ascending();

            //build the sorting based on remaining sort params
            for (int i = 1; i < sortParamList.size(); i++) {
                SortParam sortParam = sortParamList.get(i);
                if (sortParam.getSortDirection().equals(SortDirection.DESC))
                    sort.and(Sort.by(sortParam.getSortBy()).descending());
                else
                    sort.and(Sort.by(sortParam.getSortBy()).ascending());
            }
        }

        //pass the sort params
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findByTitle(query,pageable);
    }
}
