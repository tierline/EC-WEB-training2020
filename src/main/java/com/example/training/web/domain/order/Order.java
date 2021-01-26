package com.example.training.web.domain.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.training.web.domain.address.Block;
import com.example.training.web.domain.address.City;
import com.example.training.web.domain.address.Postcode;
import com.example.training.web.domain.address.Prefecture;
import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.cart.CartItem;
import com.example.training.web.domain.member.Address;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.FullName;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.member.PhoneNumber;

import lombok.Data;

@Data
public class Order {
	private Long orderId;
	private MemberId memberId;
	private Email email;
	private PhoneNumber phoneNumber;
	private FullName fullName;
	private Address address;
	// Priceクラス
	private int price;
	private String date;
	private LocalDateTime orderDateAndTime = LocalDateTime.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	/**
	 *
	 * 注文処理用コンストラクタ
	 *
	 * @param orderForm
	 * @param cart
	 */
	public Order(OrderForm orderForm, Cart cart) {
		this.memberId = new MemberId(orderForm.getMemberId());
		this.email = new Email(orderForm.getEmail());
		this.fullName = new FullName(orderForm.getLastName(), orderForm.getFirstName());
		this.address = new Address(new Postcode(orderForm.getPostcode()), new Prefecture(orderForm.getPrefecture()),
				new City(orderForm.getCity()), new Block(orderForm.getBlock()));
		this.phoneNumber = new PhoneNumber(orderForm.getPhoneNumber());
		this.date = getOrderDateAndTime().format(formatter);
	}

	// TOREVIEW 要修正、必要か？
//	public Order(int orderId, MemberId memberId, LocalDate date) {
//		this.id = orderId;
//		this.memberId = memberId;
//		this.date = date;
//	}

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
