package com.example.training.common.domain.order;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.training.common.domain.cart.Cart;
import com.example.training.domain.Address;
import com.example.training.domain.MemberId;
import com.example.training.domain.PhoneNumber;
import com.example.training.member.domain.FullName;
import com.example.training.member.domain.Member;

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

	// formでは素の型で受けて後でドメインモデルに変換する。
	@NotEmpty
	@Email
	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	private String email;
	@Valid
	private PhoneNumber phoneNumber;
	@Valid
	private FullName fullName;
	@Valid
	private Address address;
	@Valid
	private MemberId memberId;

	private LocalDateTime dateNow = LocalDateTime.now();

	public Order createOrder(Cart cart) {
		return new Order(this, cart);
	}

	/**
	 *
	 * お届け先入力フォームに会員情報をセットする
	 *
	 * @param member
	 */
	public void setMemberInfo(Member member) {
		this.fullName = member.getLastName() + member.getFirstName();
		this.lastName = member.getLastName();
		this.firstName = member.getFirstName();
		// this.fullName = this.getFullName();
		this.email = member.getEmail();
		this.phoneNumber = member.getPhoneNumber();
		this.address = member.getAddress();
		this.memberId = member.getId();
	}

	public void upDateMember(Member member) {
		member.upDateAtOrder();
	}

}
