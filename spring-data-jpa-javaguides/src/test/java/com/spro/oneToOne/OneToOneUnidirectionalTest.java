package com.spro.oneToOne;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.onoToOneUnidirectional.*;


@SpringBootTest
public class OneToOneUnidirectionalTest {

	@Autowired
	private UniOrderRepository orderRepo;
	
//	@Test 
	void saveOrder() {
		UniAddress address = new UniAddress(
				"Rud",
				"Kyiv",
				"Kyiv region",
				"Ukraine",
				"09761"
				);
		UniOrder order = new UniOrder(
				"123dsfgwer654",
				2,
				new BigDecimal( 156.45),
				"in destination",
				address
				);
		orderRepo.save(order);

	}
	
//	@Test
	void updateOrder() {
		UniOrder order= orderRepo.findById(4L).get();
		order.setStatus("delivered");
		order.getBillingAddress().setZipCode("654JJK");
		orderRepo.save(order);// if id==null ->create new row in DB, if id exists in DB -> update this row 
	}
	
	@Test
	void deleteOrder(){
		orderRepo.deleteById(2L);
	}
	
	
//	
}
