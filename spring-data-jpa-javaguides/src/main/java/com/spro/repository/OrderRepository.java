package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spro.entity.Order;



public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findByorderTrackingNumber(String number);

	@Override
	@Transactional(timeout = 10)
	void deleteById(Long id) ;
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	<S extends Order> S save(S entity);
}
