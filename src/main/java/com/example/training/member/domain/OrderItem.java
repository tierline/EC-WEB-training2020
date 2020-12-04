package com.example.training.member.domain;

import lombok.Data;

@Data
public class OrderItem {
	private String name;
	private int price;
	private int quantity;

	public OrderItem(CartItem item) {
		this.name = item.getProductName();
		this.price = item.getProductPrice();
		this.quantity = item.getQuantity();
	}

	public OrderItem() {
	}

}
