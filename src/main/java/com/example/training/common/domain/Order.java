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

import lombok.Getter;

/**
 *
 * 注文クラス
 *
 */
@Getter
public class Order {

	/**
	 * 注文ID
	 *
	 * MEMO: まず id=0L で生成し注文時の処理 useGenerateKeys で自動採番された値がセットされる。
	 */
	private OrderId id = new OrderId(0L);
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
	 * @param command 住所入力フォーム
	 * @param cart    カート
	 */
	public Order(OrderSaveCommand command, Cart cart) {
		this.memberId = new MemberId(command.getMemberId());
		this.fullName = new FullName(new Name(command.getLastName()), new Name(command.getFirstName()));
		this.address = new Address(new Postcode(command.getPostcode()), new Prefecture(command.getPrefecture()),
				new City(command.getCity()), new Block(command.getBlock()));
		this.email = new Email(command.getEmail());
		this.phoneNumber = new PhoneNumber(command.getPhoneNumber());
		this.orderDateAndTime = command.getOrderDateAndTime();
		this.totalPrice = cart.getTotalPrice();
	}

	/**
	 * テスト用コンストラクタ
	 *
	 * @param orderId          注文ID
	 * @param memberId         会員ID
	 * @param orderDateAndTime 注文日時
	 */
	public Order(OrderId orderId, MemberId memberId, LocalDateTime orderDateAndTime) {
		this.id = orderId;
		this.memberId = memberId;
		this.orderDateAndTime = orderDateAndTime;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Order() {
	}

	/**
	 * 注文商品を生成する。
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

}
