package com.spro.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spro.dto.OrderRequest;
import com.spro.dto.OrderResponse;
import com.spro.entity.Order;
import com.spro.entity.Payment;
import com.spro.exception.PaymentException;
import com.spro.repository.OrderRepository;
import com.spro.repository.PaymentRepository;
import com.spro.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository;
	private PaymentRepository paymentRepository;
	
	
	
	public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
	}



	@Override
	@Transactional
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		Order order = orderRequest.getOrder();
		order.setStatus("In progress");
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		orderRepository.save(order);
		Payment payment = orderRequest.getPayment();
		
		if(!payment.getType().equals("DEBIT")) {
			throw new PaymentException("Payment card type do not supported");
		}
		
		payment.setOrderId(order.getId());
		paymentRepository.save(payment);
		
		OrderResponse response = new OrderResponse();
		response.setOrderTrackingNumber(order.getOrderTrackingNumber());
		response.setStatus(order.getStatus());
		response.setMessage("SUCCESS");
		
		return response;
	}



	

}
