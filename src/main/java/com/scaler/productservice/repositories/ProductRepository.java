package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    <S extends Product> S save(S entity);

    //the way you can write a HQL directly
    @Query("select p.title from products p order by p.Id desc")
    List<String> findTitleByOrderByIdDesc();
}
