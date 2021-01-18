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

	/**
	 *
	 * 注文処理用コンストラクタ
	 *
	 * @param orderForm
	 * @param cart
	 */
	public Order(OrderForm orderForm, Cart cart) {
		this.memberId = orderForm.getMemberId();
		this.name = orderForm.getFullName();
		this.address = orderForm.getFullAddress();
		this.email = orderForm.getEmail();
		this.phoneNumber = orderForm.getPhoneNumber();
		this.date = orderForm.getDateNow();
	}

	/**
	 *
	 * テスト用コンストラクタ
	 *
	 * @param orderId
	 * @param memberId
	 * @param date
	 */
	public Order(int orderId, int memberId, LocalDate date) {
		this.id = orderId;
		this.memberId = memberId;
		this.date = date;
	}

	/**
	 *
	 * 注文から注文商品を生成する
	 *
	 * @param cart
	 * @return
	 */
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
