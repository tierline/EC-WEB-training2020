package com.example.training.web.domain.order;

import com.example.training.web.domain.cart.CartItem;
import com.example.training.web.domain.product.Price;
import com.example.training.web.domain.product.Quantity;

import lombok.Data;

@Data
public class OrderItem {
	private String name;
	private Price price;
	private Quantity quantity;
	private String imagePath;

	public OrderItem(CartItem item) {
		this.name = item.getProductName();
		this.price = item.getProductPrice();
		this.imagePath = item.getProductImagePath();
		this.quantity = item.getQuantity();
	}

	public OrderItem() {
	}

}
