package com.example.training.web.domain.cart;

import com.example.training.web.domain.product.Price;
import com.example.training.web.domain.product.Product;
import com.example.training.web.domain.product.Quantity;

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
		this.quantity = this.quantity.subtract(quantity);
	}

	public void resetQuantity() {
		this.quantity = this.quantity.reset();
	}

	public boolean isQuantityZero() {
		return this.quantity.isZero();
	}

	// カート内の一つの商品の合計金額を取得
	public Price multiply(Price price) {
		return price.multiply(this.quantity);
	}

}
