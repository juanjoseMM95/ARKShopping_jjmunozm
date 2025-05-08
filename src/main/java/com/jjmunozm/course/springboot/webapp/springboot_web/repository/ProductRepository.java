package com.jjmunozm.course.springboot.webapp.springboot_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductsbyShortName(@Param("descp") String filter);
    List<Product> findProductsRangePrice(@Param("min") double min, @Param("max") double max);
    List<Product> findProductsOrderByName();
}
