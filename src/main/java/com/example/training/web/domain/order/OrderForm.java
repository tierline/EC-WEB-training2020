package com.example.training.web.domain.order;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.training.web.domain.MemberEntity;
import com.example.training.web.domain.cart.Cart;

import lombok.Data;

@Data
public class OrderForm {
	public static final String SESSION_NAME = "ORDER_FORM";

	@NotEmpty
	@Email
	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	private String email;
	@NotEmpty
	@Size(min = 10, max = 11, message = "電話番号は10桁〜11桁の間で入力してください")
	@Pattern(regexp = "[0-9]*", message = "電話番号の形式が間違っています")
	private String phoneNumber;
	@NotEmpty
	@Size(min = 1, max = 5, message = "1文字以上、5文字以内で入力してください")
	private String lastName;
	@NotEmpty
	@Size(min = 1, max = 5, message = "1文字以上、5文字以内で入力してください")
	private String firstName;
	@NotEmpty
	@Size(min = 7, max = 8)
	@Pattern(regexp = "^[0-9]{3}[0-9]{4}$", message = "郵便番号の形式が間違っています")
	private String postcode;
	@NotEmpty
	@Size(min = 2, max = 4, message = "入力できる文字数を超過しています。")
	private String prefecture;
	@Size(min = 1, max = 20, message = "入力できる文字数を超過しています。")
	private String city;
	private String block;
	private Long memberId;

	private LocalDateTime orderDateAndTime = LocalDateTime.now();

	public OrderForm(OrderForm orderForm, Long memberId) {

	}

	public Order createOrder(Cart cart) {
		return new Order(this, cart);
	}

	/**
	 *
	 * お届け先入力フォームに会員情報をセットする
	 *
	 * @param member
	 */
	public void setMemberInfo(MemberEntity entity) {
		this.lastName = entity.getLastName();
		this.firstName = entity.getFirstName();
		this.email = entity.getEmail();
		this.phoneNumber = entity.getPhoneNumber();
		this.postcode = entity.getPostcode();
		this.prefecture = entity.getPrefecture();
		this.city = entity.getCity();
		this.block = entity.getBlock();
		this.memberId = entity.getMemberId();
	}
}
