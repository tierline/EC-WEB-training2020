package com.example.training.common.domain;

import org.dom4j.IllegalAddException;

public class Quantity {
	private int value;
	private final int MIN = 0;

	public Quantity(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public Quantity add(Quantity quantity) {
		if (!isAdd(quantity)) {
			throw new IllegalAddException("不正な値");
		}
		int added = addValue(quantity);
		return new Quantity(added);
	}

	public Quantity remove(Quantity quantity) {
		if (!isRemove(quantity)) {
			throw new IllegalAddException("不正な値");
		}
		int removed = removeValue(quantity);
		return new Quantity(removed);
	}

	public Quantity removeAll() {
		return new Quantity(MIN);
	}

	public Boolean isEmpty() {
		return this.value <= MIN;
	}

	private Boolean isAdd(Quantity quantity) {
		int added = addValue(quantity);
		return added > MIN;
	}

	private int addValue(Quantity quantity) {
		return this.value + quantity.value;
	}

	private Boolean isRemove(Quantity quantity) {
		int removed = removeValue(quantity);
		return removed >= MIN;
	}

	private int removeValue(Quantity quantity) {
		return this.value - quantity.value;
	}

}
