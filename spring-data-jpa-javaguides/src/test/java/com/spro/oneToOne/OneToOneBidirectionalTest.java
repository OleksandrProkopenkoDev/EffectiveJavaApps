package com.spro.oneToOne;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.Address;
import com.spro.entity.Order;
import com.spro.repository.AddressRepository;
import com.spro.repository.OrderRepository;

@SpringBootTest
public class OneToOneBidirectionalTest {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
//	@Test 
	void saveOrder() {
		Address address = new Address(
				"Bandera",
				"Kyiv",
				"Kyiv region",
				"Ukraine",
				"XXX33x"
				);
		Order order = new Order(
				"1EERer654",
				1,
				new BigDecimal( 225.00),
				"on the way"
				
				);
		address.setOrder(order);
//		orderRepo.save(order);// instead of this, we write next:
		addressRepo.save(address);
	}
	
//	@Test
	void updateAddressMethod() {
		Address address = addressRepo.findById(1L).get();
		address.getOrder().setStatus("Delivered");
		addressRepo.save(address);
	}
	
//	@Test
	void fetchAddressMethod() {
		Address address = addressRepo.findById(1L).get();
//		System.out.println(address); // printing cycles the infinite loop. Need to override toString()
	}
	
//	@Test
	void getOrder() {
		Order result = orderRepo.findById(1L).get();
		System.out.println(result);
	}
	
	@Test
	void deleteAddressMethod() {
		addressRepo.deleteById(1L);
	}
}
