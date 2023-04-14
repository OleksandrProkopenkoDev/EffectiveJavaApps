package com.spro.dto;

import com.spro.entity.Order;
import com.spro.entity.Payment;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequest {

	private Order order;
	private Payment payment;
}
