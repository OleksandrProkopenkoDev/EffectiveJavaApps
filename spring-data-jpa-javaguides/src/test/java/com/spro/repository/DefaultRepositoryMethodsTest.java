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
class DefaultRepositoryMethodsTest {

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
		product.setName("Rice");
		product.setDescription("1kg");
		product.setPrice(new BigDecimal(9.89));
		product.setSku("1260DFC");
		product.setActive(true);
		product.setImageUrl("http://biginternet.com/image/ta3g5v.png");
//		create product object
		Product product2 = new Product();
		product2.setName("rice");
		product2.setDescription("0.5kg");
		product2.setPrice(new BigDecimal(5.99));
		product2.setSku("1ss0DFC");
		product2.setActive(true);
		product2.setImageUrl("http://biginternet.com/image/sdw125v.png");
//		create product object
		Product product3 = new Product();
		product3.setName("rice");
		product3.setDescription("2kg");
		product3.setPrice(new BigDecimal(22.69));
		product3.setSku("12sDFC");
		product3.setActive(true);
		product3.setImageUrl("http://biginternet.com/image/s2qwdv.png");

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


}
