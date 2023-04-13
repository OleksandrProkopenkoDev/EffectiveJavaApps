package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findByorderTrackingNumber(String number);
}
