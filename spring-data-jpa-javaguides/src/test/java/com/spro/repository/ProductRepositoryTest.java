package com.spro.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.Product;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepo;

//	@Test
	void saveMethod() {
//		create product object
		Product product = new Product();
		product.setName("Green tea");
		product.setDescription("This is awesome milk ulun");
		product.setPrice(new BigDecimal(50.59));
		product.setSku("100ABC");
		product.setActive(true);
		product.setImageUrl("http://biginternet.com/image/sd3w5v.png");
//		save product
		try {
			Product savedObject = productRepo.save(product);
//		display
			System.out.println(savedObject);

		} catch (Exception e) {
			System.out.println("this product already exists");
		}

	}

//	@Test
	void updateUsingSaveMethod() {
//		find or retrieve an entity by id
		Long id = 9L;
		Product product = productRepo.findById(id).get();
//		update entity info
		product.setName("Amazing green tea");
		product.setDescription("This tea is grown up in chinese mountains. Big fields under the warm sun... ");

//		save updated entity
		productRepo.save(product);

	}

//	@Test
	void findByIdMethod() {
		Long id = 9L;
		Product product = productRepo.findById(id).get();
		System.out.println(product);
	}

//	@Test
	void saveAllMethod() {
//		create product object
		Product product = new Product();
		product.setName("Black tea");
		product.setDescription("Jungle mix");
		product.setPrice(new BigDecimal(52.89));
		product.setSku("121ABC");
		product.setActive(true);
		product.setImageUrl("http://biginternet.com/image/td3g5v.png");
//		create product object
		Product product2 = new Product();
		product2.setName("Black tea");
		product2.setDescription("With lemon");
		product2.setPrice(new BigDecimal(44.99));
		product2.setSku("122ABC");
		product2.setActive(true);
		product2.setImageUrl("http://biginternet.com/image/sd91w5v.png");
//		create product object
		Product product3 = new Product();
		product3.setName("Black tea");
		product3.setDescription("Earl grey");
		product3.setPrice(new BigDecimal(53.69));
		product3.setSku("123ABC");
		product3.setActive(true);
		product3.setImageUrl("http://biginternet.com/image/s23w7v.png");

		productRepo.saveAll(List.of(product, product2, product3));

	}

//	@Test
	void findAllMethod() {
		List<Product> products = productRepo.findAll();
		products.forEach((p) -> {
			System.out.println(p);
		});

	}

//	@Test
	void deleteByIdMethod() {
		Long id = 3L;
		productRepo.deleteById(id);
	}

//	@Test
	void deleteEntityMethod() {
//		find entity by id
		Long id = 1L;
		Product product = productRepo.findById(id).get();
		System.out.println(product);
		// product.setId(null);
//		delete entity
		productRepo.delete(product); // this also works with 'id' only, it delete by id underhood

	}

//	@Test
	void deleteAllMethod() {
		// productRepo.deleteAll();//hibernate select all from table, then delete by id
		// every row

		Product prod = productRepo.findById(18L).get();
		Product prod2 = productRepo.findById(17L).get();
		Product prod3 = productRepo.findById(16L).get();

		productRepo.deleteAll(List.of(prod, prod2));
	}

//	@Test
	void countMethod() {
		long count = productRepo.count();
		System.out.println("Number of rows in products table: " + count);
	}

//	@Test
	void existByIdMethod() {
		Long id = 300L;
		boolean exist = productRepo.existsById(id);
		System.out.println("Product with id=" + id + " exists? " + exist);
	}

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
	
	@Test
	void findByNameInMethod() {
		List<String> names = List.of("Green tea","Car", "Sugar");
		List<Product> results = productRepo.
				findByNameIn(names);
		System.out.println("Products with name in "+ names+" : ");
		results.forEach(item->{System.out.println(item);});
	}
}
