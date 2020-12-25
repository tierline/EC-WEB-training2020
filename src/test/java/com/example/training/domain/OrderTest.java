package com.example.training.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderMonth;
import com.example.training.common.domain.Product;

public class OrderTest {

	@Test
	void orderSave() {
		Product product = new Product(1, "ガム", 20);
		Cart cart = new Cart();
		cart.add(product);

	}

	@Test
	void orderMonth() {
		List<Order> order = new ArrayList<Order>();
		List<Integer> monthList = new ArrayList<>();
		List<OrderMonth> result = new ArrayList<>();
		Order order1 = new Order(1, 1, LocalDate.of(2020, 10, 22));
		Order order2 = new Order(2, 1, LocalDate.of(2020, 12, 12));
		Order order3 = new Order(3, 1, LocalDate.of(2020, 12, 25));
		Order order4 = new Order(4, 1, LocalDate.of(2020, 10, 2));
		Order order5 = new Order(5, 1, LocalDate.of(2020, 10, 18));
		// orderのリスト
		order.add(order1);
		order.add(order2);
		order.add(order3);
		order.add(order4);
		order.add(order5);
		for (Order o : order) {
			int month = o.getDate().getMonthValue();
			monthList.add(month);
		}
		// 重複した月の排除
		List<Integer> month = new ArrayList<Integer>(new LinkedHashSet<>(monthList));
		List<Order> day = new ArrayList<>();
		for (int m : month) {
			for (Order o : order) {
				if (m == o.getDate().getMonthValue()) {
					day.add(o);
				}
			}
			OrderMonth orderMonth = new OrderMonth();
			orderMonth.setOrderMonth(m);
			orderMonth.add(day);
			result.add(orderMonth);
			day = new ArrayList<>();

		}
	}
}
