package com.spro.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.Product;
@SpringBootTest
public class FinderMethods {

	@Autowired
	private ProductRepository productRepo;

	// ------------------------query methods-------------------------

//	@Test
	void queryMethodsByName() {
		String name = "Green tea";
		List<Product> result = productRepo.findByName(name);
		boolean exists = productRepo.existsByName(name);
		int count = productRepo.countByName(name);
		List<Product> byPrice = productRepo.findByPriceGreaterThan(new BigDecimal(50));
//		int deleteCount = productRepo.deleteByName(name); //delete by name more than one dont work
		System.out.println("FindByName " + name + " " + result);
		System.out.println("ExistsByName " + name + " " + exists);
		System.out.println("CountByName " + name + " " + count);
		System.out.println("byPriceGraterThan 50 " + " " + byPrice);
//		System.out.println("DeleteByName "+name + " "+ deleteCount);
	}

//	@Test
	void queryByNameOrDesriptionMethod() {
		String name = "Black tea";
		String description = "Mango mix";
		List<Product> products = productRepo.findByNameOrDescription(name, description);
		System.out.println(products);
	}

//	@Test
	void queryByNameAndDesriptionMethod() {
		String name = "Green tea";
		String description = "Mango mix";
		List<Product> products = productRepo.findByNameAndDescription(name, description);
		System.out.println(products);
	}

//	@Test
	void findDistinctByNameMethod() {
		String name = "Green tea";
		List<Product> result = productRepo.findDistinctByName(name);
		System.out.println("found by name " + name + " product is: " + result);

	}

//	@Test
	void findByNameContainingMethod() {
		String name = "tea";
		String description = "mix";
		List<Product> result1 = productRepo.findByNameContaining(name);
		List<Product> result2 = productRepo.findByDescriptionContaining(description);
		System.out.println("found by name containing '" + name + "' : " + result1);
		System.out.println("found by description containing '" + description + "' : " + result2);
	}
	
//	@Test
	void findByNameLikeMethod() {
		String name = "Gr_en%";
		List<Product> result = productRepo.findByNameLike(name);
		System.out.println("found by name like '" + name + "' : " + result);

	}
	
//	@Test
	void findByPriceBetweenMethod() {
		BigDecimal startPrice = new BigDecimal(50);
		BigDecimal endPrice = new BigDecimal(55);
		List<Product> results = productRepo.findByPriceBetween(startPrice, endPrice);
		System.out.println("Products with price between "+startPrice+" and "+endPrice+" : ");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findByDateBetweenMethod() {
		LocalDateTime startDate = LocalDateTime.of(2023, 4, 8, 17, 35);
		LocalDateTime endDate = LocalDateTime.now();
		List<Product> results = productRepo.
				findByDateCreatedBetween(startDate, endDate);
		System.out.println("Products with date between "+startDate+" and "+endDate+" : ");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findByNameInMethod() {
		List<String> names = List.of("Green tea","Car", "Sugar");
		List<Product> results = productRepo.
				findByNameIn(names);
		System.out.println("Products with name in "+ names+" : ");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findFirstByNameMethod() {
		String name = "Green tea";
		Product result = productRepo.findFirstByName(name);
		System.out.println("Find first by name '"+name+"' : "+result);
	}
	
//	@Test
	void findTop3ByNameMethod() {
		String name = "Green tea";
		List<Product> results = productRepo.
				findTop3ByName(name);
		System.out.println("Top 3 products by name '"+ name+"' : ");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findTop3ByOrderByPriceDescMethod() {
		List<Product> results = productRepo.
				findTop3ByOrderByPriceDesc();
		System.out.println("Top 3 products by price : ");
		results.forEach(item->{System.out.println(item);});
	}
	

}
