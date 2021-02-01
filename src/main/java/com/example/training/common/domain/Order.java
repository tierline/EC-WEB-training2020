package com.example.training.common.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.training.common.controller.OrderSaveCommand;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.FullName;
import com.example.training.common.domain.value.Name;
import com.example.training.common.domain.value.PhoneNumber;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.address.Address;
import com.example.training.common.domain.value.address.Block;
import com.example.training.common.domain.value.address.City;
import com.example.training.common.domain.value.address.Postcode;
import com.example.training.common.domain.value.address.Prefecture;
import com.example.training.common.domain.value.id.MemberId;
import com.example.training.common.domain.value.id.OrderId;

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
	private OrderId id;
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
	private Email email;
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
	private LocalDateTime orderDateAndTime;

	/**
	 * 注文処理用コンストラクタ
	 *
	 * @param orderSaveCommand 住所入力フォーム
	 * @param cart             カート
	 */
	public Order(OrderSaveCommand orderSaveCommand, Cart cart) {
		// MEMO: まず id=0 で生成し注文時の処理 useGenerateKeys で自動採番された値がセットされる。
		this.id = new OrderId(0L);
		this.memberId = new MemberId(orderSaveCommand.getMemberId());
		this.fullName = new FullName(new Name(orderSaveCommand.getLastName()), new Name(orderSaveCommand.getFirstName()));
		this.address = new Address(new Postcode(orderSaveCommand.getPostcode()),
				new Prefecture(orderSaveCommand.getPrefecture()), new City(orderSaveCommand.getCity()),
				new Block(orderSaveCommand.getBlock()));
		this.email = new Email(orderSaveCommand.getEmail());
		this.phoneNumber = new PhoneNumber(orderSaveCommand.getPhoneNumber());
		this.orderDateAndTime = orderSaveCommand.getOrderDateAndTime();
		this.totalPrice = cart.getTotalPrice();
	}

	/**
	 * テスト用コンストラクタ
	 *
	 * @param orderId  注文ID
	 * @param memberId 会員ID
	 * @param date     注文日時
	 */
	public Order(Long orderId, MemberId memberId, LocalDateTime orderDateAndTime) {
		this.id = new OrderId(orderId);
		this.memberId = memberId;
		this.orderDateAndTime = orderDateAndTime;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Order() {
	}

	/**
	 * 注文商品を作る。
	 *
	 * @param cart カート
	 * @return 注文した商品
	 */
	public List<OrderItem> createOrderItems(Cart cart, Order order) {
		List<OrderItem> results = new ArrayList<OrderItem>(cart.getSize());
		for (CartItem item : cart.getItems()) {
			results.add(new OrderItem(item, order));
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
