package com.example.training.web.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.cart.CartItem;
import com.example.training.web.domain.member.FullName;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.member.PhoneNumber;
import com.example.training.web.domain.member.address.Address;
import com.example.training.web.domain.product.Price;

import lombok.Data;

@Data
public class Order {
	private int id;
	private MemberId memberId;
	private FullName fullName;
	private Address address;
	private String email;
	private PhoneNumber phoneNumber;
	private Price price;
	private Date date;

	/**
	 *
	 * 注文処理用コンストラクタ
	 *
	 * @param orderForm
	 * @param cart
	 */
	public Order(OrderForm orderForm, Cart cart) {
		this.memberId = orderForm.getMemberId();
		this.fullName = orderForm.getFullName();
		this.address = orderForm.getAddress();
		this.email = orderForm.getEmail();
		this.phoneNumber = orderForm.getPhoneNumber();
		this.date = orderForm.getOrderDateAndTime();
		this.price = cart.getTotalAmount();
	}

	// TOREVIEW 要修正、必要か？
	public Order(int orderId, MemberId memberId, LocalDateTime date) {
		this.id = orderId;
		this.memberId = memberId;
		this.date = new Date(date);
	}

	// public Order(int orderId, MemberId memberId, String email, PhoneNumber
	// phone_number, FullName fullName,
	// Address address, int price, LocalDate date) {
	// this(orderId, memberId, date);
	// this.email = email;
	// this.phoneNumber = phone_number;
	// this.fullName = fullName;
	// this.address = address;
	// this.price = price;
	//
	// }

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

	public void setPrice(Price price) {
		this.price = price;
	}

	public void setPrice(Cart cart) {
		Price total = new Price(0);
		for (CartItem item : cart.getItems()) {
			// total += item.getTotalAmount();
			item.getTotalAmount().add(total);
		}
		this.price = total;
	}
}
