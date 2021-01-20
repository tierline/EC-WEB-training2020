package com.example.training.common.domain.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.training.common.domain.cart.Cart;
import com.example.training.common.domain.cart.CartItem;
import com.example.training.member.domain.Address;
import com.example.training.member.domain.FullName;
import com.example.training.member.domain.MemberId;
import com.example.training.member.domain.PhoneNumber;

import lombok.Data;

@Data
public class Order {

	// クラスのコメント,メソッドのコメントをjavadocで。
	// メソッドのコメントは「何をやっているか」は日本語で書いていきたい

	private int id;
	private MemberId memberId;
	private FullName fullName;
	private Address address;
	private String email;
	private PhoneNumber phoneNumber;
	// Priceクラス
	private int price;
	private LocalDate date;

	public Order(OrderForm orderForm, Cart cart) {
		this.memberId = orderForm.getMemberId();
		this.fullName = orderForm.getFullName();
		this.address = orderForm.getAddress();
		this.email = orderForm.getEmail();
		this.phoneNumber = orderForm.getPhoneNumber();
		this.date = orderForm.getDateNow();
	}

	// TOREVIEW 要修正、必要か？
	public Order(int orderId, MemberId memberId, LocalDate date) {
		this.id = orderId;
		this.memberId = memberId;
		this.date = date;
	}

//	public Order(int orderId, MemberId memberId, String email, PhoneNumber phone_number, FullName fullName,
//			Address address, int price, LocalDate date) {
//		this(orderId, memberId, date);
//		this.email = email;
//		this.phoneNumber = phone_number;
//		this.fullName = fullName;
//		this.address = address;
//		this.price = price;
//
//	}

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
