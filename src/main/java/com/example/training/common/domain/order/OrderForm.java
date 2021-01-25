package com.example.training.common.domain.order;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.training.common.OrderFormEntity;
import com.example.training.common.domain.Date;
import com.example.training.common.domain.cart.Cart;
import com.example.training.member.domain.Address;
import com.example.training.member.domain.FullName;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberId;
import com.example.training.member.domain.PhoneNumber;
import com.example.training.member.domain.address.Block;
import com.example.training.member.domain.address.City;
import com.example.training.member.domain.address.Postcode;
import com.example.training.member.domain.address.Prefecture;

import lombok.Data;

@Data
public class OrderForm {
	public static final String SESSION_NAME = "ORDER_FORM";

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

	public OrderForm() {
	}

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

	private Date orderDateAndTime = new Date(LocalDateTime.now());

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
		this.fullName = member.getFullName();
		this.email = member.getEmail();
		this.phoneNumber = member.getPhoneNumber();
		this.address = member.getAddress();
		this.memberId = member.getId();
	}

}
