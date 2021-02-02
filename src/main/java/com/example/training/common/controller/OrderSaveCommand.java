package com.example.training.common.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Order;

import lombok.Data;

/**
 * 注文フォームクラス
 */
@Data
public class OrderSaveCommand {
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
	private LocalDateTime orderDateAndTime = LocalDateTime.now();

	/**
	 * カートから注文クラスを生成する。
	 *
	 * @param cart
	 * @return 注文クラス
	 */
	public Order createOrderFrom(Cart cart) {
		return new Order(this, cart);
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public OrderSaveCommand() {
	}

	/**
	 * お届け先入力フォームに会員情報をセットする。
	 *
	 * @param member 会員
	 */
	public void setMemberInfo(MemberDTO memberDTO) {
		this.lastName = memberDTO.getLastName();
		this.firstName = memberDTO.getFirstName();
		this.email = memberDTO.getEmail();
		this.phoneNumber = memberDTO.getPhoneNumber();
		this.postcode = memberDTO.getPostcode();
		this.prefecture = memberDTO.getPrefecture();
		this.city = memberDTO.getCity();
		this.block = memberDTO.getBlock();
		this.orderDateAndTime = getOrderDateAndTime();
		this.memberId = memberDTO.getMemberId();
	}

	/**
	 * 氏名を取得する。
	 *
	 * @return
	 */
	public String getFullName() {
		return lastName + firstName;
	}

	/**
	 * 住所全文を取得する。
	 */
	public String getAddress() {
		return "〒" + postcode + " " + prefecture + " " + city + " " + block;
	}

	/**
	 * フォーマットされた注文日時を返す。
	 *
	 * @return
	 */
	public String getFormattedOrderDateAndTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh時mm分ss秒");
		return orderDateAndTime.format(formatter);
	}

}
