package com.spro.service;

import com.spro.dto.OrderRequest;
import com.spro.dto.OrderResponse;

public interface OrderService {

	OrderResponse placeOrder(OrderRequest orderRequest);
}
