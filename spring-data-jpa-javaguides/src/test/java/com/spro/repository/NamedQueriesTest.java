package com.spro.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.Product;

@SpringBootTest
public class NamedQueriesTest {

	@Autowired
	private ProductRepository productRepo;
  
//	@Test
	void findBySkuMethod() {
		String sku = "101ABC";
		Product result = productRepo.findBySku(sku);
		System.out.println("find by sku '"+sku+"' : " + result);
	}
	
//	@Test
	void findByPriceMethod() {
		BigDecimal price = new BigDecimal(49.99);// don`t work because of floating numbers
		List<Product> result = productRepo.findByPrice(price);
		System.out.println("find by price '"+price+"' : " + result);
	}
	
//	@Test
	void findAllOrderByNameDesc() {
		List<Product> results = productRepo.
				findAllOrderByNameDesc();
		System.out.println("find all, order by name descending :");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findAllOrderBySkuDesc() {
		List<Product> results = productRepo.
				findAllOrderBySkuDesc();
		System.out.println("find all, order by sku descending :");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findAllOrderByPriceAscMethod() {
		List<Product> results = productRepo.
				findAllOrderByPriceAsc();
		System.out.println("find all, order by price ascending :");
		results.forEach(item->{System.out.println(item);});
	}

//	@Test
	void findByCreationDateMethod() {
		LocalDateTime date = LocalDateTime.of(2023, 4, 9, 0, 0);
		List<Product> results = productRepo.
				findByCreationDate(date);
		System.out.println("findByCreationDate : "+date);
		results.forEach(item->{System.out.println(item);});
	}
	
	@Test
	void findAllOrderByAscMethod() {
		List<Product> results = productRepo.
				findAllOrderByAsc();
		System.out.println("find all, ascending by creation date : ");
		results.forEach(item->{System.out.println(item);});
	}
}
