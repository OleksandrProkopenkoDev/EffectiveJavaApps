package com.spro.oneToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.Address;
import com.spro.entity.Order;
import com.spro.entity.OrderItem;
import com.spro.entity.Product;
import com.spro.entity.ProductCategory;
import com.spro.repository.OrderRepository;
import com.spro.repository.ProductCategoryRepository;
import com.spro.repository.ProductRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class OneToManyTest {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductCategoryRepository pCategoryRepo;
	
//	@Test
	void saveOrderMethod() {
//		create order items
		OrderItem item1 = new OrderItem(
				"http://pics.com/aaa32u4.jpg",
				5);
		OrderItem item2 = new OrderItem(
				"http://pics.com/aww32u4.jpg",
				2);
		item1.setProduct(productRepo.findById(32L).get());
		item2.setProduct(productRepo.findById(23L).get());
		item1.calculateAndSetPrice();
		item2.calculateAndSetPrice();
//		create address
		Address address = new Address(
				"Sirko",
				"Vinitsa",
				"region",
				"Ukraine",
				"1111x"
				);
//		create order
		Order order = new Order(
				"Order#1127PP",
				"New order");
		order.setBillingAddress(address);
		order.getOrderItems().add(item1);
		order.getOrderItems().add(item2);
		order.calculateAndSetTotalPrice();
		
		orderRepo.save(order);
	}
	
//	@Test
	void fetchOrderMethod() {
		Order order = orderRepo.findById(3L).get();
		System.out.println(order);
		//we have an issue: billingAddress is null. Address doesn`t save with order((((
	}
	
//	@Test
	void deleteOrder() {
		orderRepo.deleteById(2L);
	}
	
//	@Test
	void saveProductCategory() {
//		ProductCategory category = new ProductCategory("bakery", 
//				"This is a place for groats, tea, coffee and so on");
		ProductCategory category = pCategoryRepo.findById(7L).get();
		Product prod1 = productRepo.findById(48L).get();
		Product prod2 = productRepo.findById(42L).get();
		prod1.setId(null);
		prod2.setId(null);
		prod1.setSku("qqq1127");
		prod2.setSku("qqq1128");
		prod1.setCategory(category);
		prod2.setCategory(category);
		
//		Hibernate.initialize(category.getProducts());
		category.getProducts().add(prod1);
		category.getProducts().add(prod2);

		pCategoryRepo.save(category);
	}
	
//	@Test
	void deleteProductCategory() {
		pCategoryRepo.deleteById(6L);
	}
	
	@Test
	@Transactional
	void fetchProductCategory() {
		ProductCategory category = pCategoryRepo.findById(7L).get();
		System.out.println(category);
		System.out.println(category.getProducts().get(0));
	}
}
