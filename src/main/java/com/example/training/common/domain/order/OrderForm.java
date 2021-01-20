package com.example.training.common.domain.order;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.training.common.domain.cart.Cart;
import com.example.training.member.domain.Address;
import com.example.training.member.domain.FullName;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberId;
import com.example.training.member.domain.PhoneNumber;

import lombok.Data;

@Data
public class OrderForm {
	public static final String SESSION_NAME = "ORDER_FORM";

	public OrderForm(OrderForm form, MemberId id) {
		this.fullName = form.getFullName();
		this.email = form.getEmail();
		this.phoneNumber = form.getPhoneNumber();
		this.address = form.getAddress();
		this.dateNow = getDateNow();
		this.memberId = id;
	}

	public OrderForm() {
	}

	/**
	 * 連絡先情報
	 */
	@NotEmpty
	@Email
	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	private String email;

	private PhoneNumber phoneNumber;

	/**
	 * 基本情報
	 */

	private FullName fullName;
	/**
	 * 住所情報
	 */

	private Address address;

	@NotNull
	private MemberId memberId;

	private LocalDate dateNow = LocalDate.now();

	public Order createOrder(Cart cart) {
		return new Order(this, cart);
	}

	public void setMemberInfo(Member member) {
		this.fullName = member.getFullName();
		this.email = member.getEmail();
		this.phoneNumber = member.getPhoneNumber();
		this.address = member.getAddress();
		this.memberId = member.getId();
	}

}
