package com.example.training.domain;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.repository.OrderRepository;

@Service
public class OrderService {
	public static final String SESSION_NAME = "ORDER_PERSON";

	@Autowired
	private OrderRepository orderRepository;

	public int order(@Valid OrderForm orderForm, Cart cart) {
		Order order = orderForm.createOrder();
		order.setPrice(cart);
		orderRepository.save(order);
		List<OrderItem> items = order.createItems(cart);
		for (OrderItem item : items) {
			orderRepository.saveItem(item, order.getId());
		}
		return order.getId();
	}
}
