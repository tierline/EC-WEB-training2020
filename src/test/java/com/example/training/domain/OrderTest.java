package com.example.training.domain;

import org.junit.jupiter.api.Test;

import com.example.training.member.domain.Cart;
import com.example.training.member.domain.Product;

public class OrderTest {

	@Test
	void orderSave() {
		Product product = new Product(1, "ガム", 20);
		Cart cart = new Cart();
		cart.add(product);

	}
}
