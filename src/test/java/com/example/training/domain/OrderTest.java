package com.example.training.domain;

import org.junit.jupiter.api.Test;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;

public class OrderTest {

	@Test
	void orderSave() {
		Product product = new Product(1, "ガム", 20);
		Cart cart = new Cart();
		cart.add(product);

	}
}
