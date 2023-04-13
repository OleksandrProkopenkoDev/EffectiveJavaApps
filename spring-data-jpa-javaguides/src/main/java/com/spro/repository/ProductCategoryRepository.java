package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
