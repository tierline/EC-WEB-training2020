package com.example.training.common.domain;

public class Price {
	private int value;

	public Price(int value) {
		this.value = value;
	}

	public Price add(Price price) {
		int added = this.value + price.value;
		return new Price(added);
	}

	public Price oneProductTotalAmount(Price price, Quantity quantity) {
		int total = price.value * quantity.getValue();
		return new Price(total);
	}

	public Price AllProductTotalAmount(Price price, Quantity quantity) {

	}
}
