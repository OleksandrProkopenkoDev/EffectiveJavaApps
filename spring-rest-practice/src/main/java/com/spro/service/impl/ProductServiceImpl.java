package com.spro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spro.entity.Product;
import com.spro.repository.ProductRepository;
import com.spro.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepo;
	
	
	
	public ProductServiceImpl(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}



	@Override
	public List<Product> searchProducts(String query) {
		List<Product> products =  productRepo.searchProductsJPQL(query);
		return products;
	}



	@Override
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	

}
