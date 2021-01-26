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

/**
 *
 * 注文クラス
 *
 */
@Data
public class Order {

	/**
	 * 注文ID
	 */
	private int id;
	/**
	 * 会員ID
	 */
	private MemberId memberId;
	/**
	 * 会員の氏名
	 */
	private FullName fullName;
	/**
	 * 会員の住所
	 */
	private Address address;
	/**
	 * 会員のEメールアドレス
	 */
	private String email;
	/**
	 * 会員の電話番号
	 */
	private PhoneNumber phoneNumber;
	/**
	 * 注文合計金額
	 */
	private Price totalPrice;
	/**
	 * 注文日時
	 */
	private Date orderDate;

	/**
	 * 注文処理用コンストラクタ
	 *
	 * @param orderForm 住所入力フォーム
	 * @param cart      カート
	 */
	public Order(OrderForm orderForm, Cart cart) {
		this.memberId = orderForm.getMemberId();
		this.fullName = orderForm.getFullName();
		this.address = orderForm.getAddress();
		this.email = orderForm.getEmail();
		this.phoneNumber = orderForm.getPhoneNumber();
		this.orderDate = orderForm.getOrderDateAndTime();
		this.totalPrice = cart.getTotalPrice();
	}

	/**
	 * テスト用コンストラクタ
	 *
	 * @param orderId  注文ID
	 * @param memberId 会員ID
	 * @param date     注文日時
	 */
	public Order(int orderId, MemberId memberId, LocalDateTime orderDate) {
		this.id = orderId;
		this.memberId = memberId;
		this.orderDate = new Date(orderDate);
	}

	/**
	 * カートの商品から注文商品を生成する
	 *
	 * @param cart カート
	 * @return 注文した商品
	 */
	public List<OrderItem> createOrderItemsFrom(Cart cart) {
		List<OrderItem> results = new ArrayList<OrderItem>(cart.getSize());
		for (CartItem item : cart.getItems()) {
			results.add(new OrderItem(item));
		}
		return results;
	}

	/**
	 * 合計金額をセットする。
	 *
	 * @param cart カート
	 */
	public void setPrice(Cart cart) {
		Price total = new Price(0);
		for (CartItem item : cart.getItems()) {
			item.getTotalPrice().add(total);
		}
		this.totalPrice = total;
	}
}
