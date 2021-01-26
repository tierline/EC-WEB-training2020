package com.example.training.web.domain.order;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.member.FullName;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.member.PhoneNumber;
import com.example.training.web.domain.member.address.Address;
import com.example.training.web.domain.member.address.Block;
import com.example.training.web.domain.member.address.City;
import com.example.training.web.domain.member.address.Postcode;
import com.example.training.web.domain.member.address.Prefecture;

import lombok.Data;

/**
 *
 * 注文フォームクラス
 *
 */
@Data
public class OrderForm {
	public static final String SESSION_NAME = "ORDER_FORM";

	/**
	 * Eメール
	 */
	@NotEmpty
	@Email
	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	private String email;

	/**
	 * 電話番号
	 */
	@Valid
	private PhoneNumber phoneNumber;

	/**
	 * 名前
	 */
	@Valid
	private FullName fullName;

	/**
	 * 住所
	 */
	@Valid
	private Address address;

	/**
	 * 会員ID
	 */
	@Valid
	private MemberId memberId;

	/**
	 * 注文日時
	 */
	private Date orderDateAndTime = new Date(LocalDateTime.now());

	/**
	 * Mobileの注文用コンストラクタ
	 *
	 * @param orderFormEntity
	 * @param memberId
	 */
	public OrderForm(OrderFormEntity orderFormEntity, MemberId memberId) {
		this.fullName = new FullName(orderFormEntity.getLastName(), orderFormEntity.getFirstName());
		this.email = orderFormEntity.getEmail();
		this.phoneNumber = new PhoneNumber(orderFormEntity.getPhoneNumber());
		Postcode postcode = new Postcode(orderFormEntity.getPostcode());
		Prefecture prefecture = new Prefecture(orderFormEntity.getPrefecture());
		City city = new City(orderFormEntity.getCity());
		Block block = new Block(orderFormEntity.getBlock());
		this.address = new Address(postcode, prefecture, city, block);
		this.orderDateAndTime = getOrderDateAndTime();
		this.memberId = memberId;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public OrderForm() {
	}

	/**
	 * カートから注文クラスを作る。
	 *
	 * @param cart
	 * @return 注文クラス
	 */
	public Order createOrderFrom(Cart cart) {
		return new Order(this, cart);
	}

	/**
	 * お届け先入力フォームに会員情報をセットする。
	 *
	 * @param member 会員
	 */
	public void setMemberInfo(Member member) {
		this.fullName = member.getFullName();
		this.email = member.getEmail();
		this.phoneNumber = member.getPhoneNumber();
		this.address = member.getAddress();
		this.memberId = member.getId();
	}

}
