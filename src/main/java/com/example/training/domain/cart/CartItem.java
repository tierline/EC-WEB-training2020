package com.example.training.domain.cart;

import com.example.training.domain.Product;
import com.example.training.domain.Quantity;

public class CartItem {
	private Product product;
	private Quantity quantity;

	public CartItem(Product product) {
		this.product = product;
		this.quantity = new Quantity(1);
	}

	public int getProductId() {
		return product.getId();
	}

	public String getProductImage() {
		return product.getImagePath();
	}

	public String getProductName() {
		return product.getName();
	}

	public int getProductPrice() {
		return product.getPrice();
	}

	public Quantity getQuantity() {
		return this.quantity;
	}

	public void addQuantity(Quantity quantity) {
		this.quantity = this.quantity.add(quantity);
	}

	public void changeQuantity(Quantity quantity) {
		this.quantity = new Quantity(quantity.getValue());
	}

	public void removeQuantity(Quantity quantity) {
		this.quantity = new Quantity(this.quantity.getValue() - quantity.getValue());
	}

	public void removeAll() {
		this.quantity = this.quantity.removeAll();
	}

	public boolean isEmpty() {
		return this.quantity.isEmpty();
	}

	// カート内の一つの商品の合計金額を取得
	public int getTotalAmount() {
		int price = this.getProductPrice() * this.getQuantity().getValue();
		return price;
	}
}
