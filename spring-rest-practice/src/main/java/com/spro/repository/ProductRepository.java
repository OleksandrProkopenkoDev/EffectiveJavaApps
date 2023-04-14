package com.spro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spro.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("select p from Product p where "
			+ "p.name like concat('%', :query, '%') OR "
			+ "p.description Like concat('%', :query, '%')")
	List<Product> searchProductsJPQL(String query);
	
	@Query(value ="select * from products p where "
			+ "p.name like concat('%', :query, '%') OR "
			+ "p.description Like concat('%', :query, '%')",
			nativeQuery = true)
	List<Product> searchProductsSQL(String query);
}
