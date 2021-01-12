package com.example.training.common.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {

	private int id;
	private int memberId;
	private String name;
	private String address;
	private String email;
	private String phoneNumber;
	private int price;
	private LocalDate date;

	public Order(OrderForm orderForm) {
		this.memberId = orderForm.getMemberId();
		this.name = orderForm.getFullName();
		this.address = orderForm.getFullAddress();
		this.email = orderForm.getEmail();
		this.phoneNumber = orderForm.getPhoneNumber();
		this.date = orderForm.getDateNow();
	}

	//要修正、いる？
	public Order(int orderId, int memberId, String email, String phone_number, String name, String address, int price,
			LocalDate date) {
		this.id = orderId;
		this.memberId = memberId;
		this.email = email;
		this.phoneNumber = phone_number;
		this.name = name;
		this.address = address;
		this.price = price;
		this.date = date;
	}

	//test用で作っていいのか
	public Order(int orderId, int memberId, LocalDate date) {
		this.id = orderId;
		this.memberId = memberId;
		this.date = date;
	}

	public List<OrderItem> createItems(Cart cart) {
		List<OrderItem> results = new ArrayList<OrderItem>(cart.getSize());
		for (CartItem item : cart.getItems()) {
			results.add(new OrderItem(item));
		}
		return results;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPrice(Cart cart) {
		int total = 0;
		for (CartItem item : cart.getItems()) {
			total += item.getTotalAmount();
		}
		this.price = total;
	}
}
