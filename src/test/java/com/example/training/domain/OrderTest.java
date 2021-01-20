package com.example.training.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderHistoryAssembler;
import com.example.training.common.domain.Product;

import org.junit.jupiter.api.Test;

public class OrderTest {

	@Test
	void orderSave() {
		Product product = new Product(1, "ガム", 20);
		Cart cart = new Cart();
		cart.add(product);

	}

	@Test
	void orderMonth() {
		OrderHistoryAssembler history = new OrderHistoryAssembler();
		List<Order> orders = new ArrayList<Order>();
		Order order1 = new Order(1, 1, LocalDate.of(2020, 10, 22));
		Order order2 = new Order(2, 1, LocalDate.of(2020, 12, 12));
		Order order3 = new Order(3, 1, LocalDate.of(2020, 12, 25));
		Order order4 = new Order(4, 1, LocalDate.of(2020, 10, 2));
		Order order5 = new Order(5, 1, LocalDate.of(2020, 10, 18));
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		orders.add(order5);
		// history.create(1);
	}
}
