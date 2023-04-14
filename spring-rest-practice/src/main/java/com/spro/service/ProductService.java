package com.spro.service;

import java.util.List;

import com.spro.entity.Product;

public interface ProductService {

	List<Product> searchProducts(String query);

	Product createProduct(Product product);
}
