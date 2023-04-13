package com.spro.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.Product;

@SpringBootTest
public class JpqlAndSqlMethodsTest {

	@Autowired
	private ProductRepository productRepo;

//----------------@Query("...") methods---------------------
	
//	@Test
	void findMyProductMethod() {
		String name = "Green tea";
		String description = "Mango mix";
		List<Product> results = productRepo.
				findMyProduct(name, description);
		System.out.println("findMyProduct with name '"+name+
				"' or description '"+description+"':");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findAllSQLMethod() {
		List<Product> results = productRepo.
				findMyAllProductsSQL();
		System.out.println("find all using sql :");
		results.forEach(item->{System.out.println(item);});
	}

//	@Test
	void findByNameAndDescriptionJPQLParamMethod() {
		String name = "Black tea";
		String description = "Mango mix";
		List<Product> results = productRepo.
				findByNameAndDescriptionJPQLParam(description, name);
		System.out.println("findMyProduct with name '"+name+
				"' or description '"+description+"':");
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void findByNameAndDescSQLMethod() {
		String name = "Black tea";
		String description = "Mango mix";
		List<Product> results = productRepo.
				findByNameAndDescSQL(name, description);
		System.out.println("findMyProduct with name '"+name+
				"' or description '"+description+"':");
		results.forEach(item->{System.out.println(item);});
	}

//	@Test
	void findByNameAndDescSQLParamMethod() {
		String name = "Black tea";
		String description = "Mango mix";
		List<Product> results = productRepo.
				findByNameAndDescSQLParam( description, name);
		System.out.println("findMyProduct with name '"+name+
				"' or description '"+description+"':");
		results.forEach(item->{System.out.println(item);});
	}
}
