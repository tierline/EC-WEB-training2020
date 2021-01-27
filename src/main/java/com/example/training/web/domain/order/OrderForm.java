package com.example.training.web.domain.order;

import java.time.LocalDateTime;


import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.member.FullName;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.MemberDto;
import com.example.training.web.domain.member.MemberId;

import lombok.Data;

/**
 * 注文フォームクラス
 */
@Data
public class OrderForm {
	public static final String SESSION_NAME = "ORDER_FORM";

	/**
	 * 姓
	 */
	@NotEmpty
	@Size(min = 1, max = 16, message = "姓は1文字以上、16字以内で入力してください")
	private String lastName;

	/**
	 * 名
	 */
	@NotEmpty
	@Size(min = 1, max = 16, message = "名は1文字以上、16文字以内で入力してください")
	private String firstName;

	/**
	 * Eメール
	 */
	@NotEmpty
	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Eメールの形式が間違っています")
	private String email;

	/**
	 * 電話番号
	 */
	@NotEmpty
	@Size(min = 10, max = 11, message = "電話番号は10桁〜11桁の間で入力してください")
	@Pattern(regexp = "[0-9]*", message = "電話番号の形式が間違っています")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@NotEmpty
	@Size(min = 7, max = 8)
	@Pattern(regexp = "^[0-9]{3}[0-9]{4}$", message = "郵便番号の形式が間違っています")
	private String postcode;

	/**
	 * 都道府県
	 */
	@NotEmpty
	@Size(max = 4, message = "入力できる文字数を超過しています。")
	private String prefecture;

	/**
	 * 市区町村
	 */
	@Size(min = 1, max = 20, message = "入力できる文字数を超過しています。")
	private String city;

	/**
	 * 番地
	 */
	@Size(max = 128, message = "入力できる文字数を超過しています。")
	@NotEmpty
	private String block;

	/**
	 * 会員ID
	 */
	private Long memberId;

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
		this.lastName = orderFormEntity.getLastName();
		this.firstName = orderFormEntity.getFirstName();
		this.email = orderFormEntity.getEmail();
		this.phoneNumber = orderFormEntity.getPhoneNumber();
		this.postcode = orderFormEntity.getPostcode();
		this.prefecture = orderFormEntity.getPrefecture();
		this.city = orderFormEntity.getCity();
		this.block = orderFormEntity.getBlock();
		this.orderDateAndTime = getOrderDateAndTime();
		this.memberId = memberId.getValue();
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
	public void setMemberInfo(MemberDto memberDto) {
		this.lastName = memberDto.getLastName();
		this.firstName = memberDto.getFirstName();
		this.email = memberDto.getEmail();
		this.phoneNumber = memberDto.getPhoneNumber();
		this.postcode = memberDto.getPostcode();
		this.prefecture = memberDto.getPrefecture();
		this.city = memberDto.getCity();
		this.block = memberDto.getBlock();
		this.orderDateAndTime = getOrderDateAndTime();
		this.memberId = memberDto.getMemberId();
	}

}
