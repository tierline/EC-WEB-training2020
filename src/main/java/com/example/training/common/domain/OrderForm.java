package com.example.training.common.domain;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OrderForm {

	public OrderForm(OrderForm form, int id) {
		this.lastName = form.getLastName();
		this.firstName = form.getFirstName();
		this.email = form.getEmail();
		this.phoneNumber = form.getPhoneNumber();
		this.postcode = form.getPostcode();
		this.prefecture = form.getPrefecture();
		this.city = form.getCity();
		this.block = form.getBlock();
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

	@NotEmpty
	@Size(min = 10, max = 11, message = "電話番号は10桁〜11桁の間で入力してください")
	@Pattern(regexp = "[0-9]*", message = "ハイフンなしの半角英数字で入力してください")
	private String phoneNumber;

	/**
	 * 基本情報
	 */
	@NotEmpty
	@Size(min = 1, max = 16, message = "姓は1文字以上、16文字以内で入力して下さい。")
	private String lastName;

	@NotEmpty
	@Size(min = 1, max = 16, message = "名は1文字以上、16文字以内で入力して下さい。")
	private String firstName;

	/**
	 * 住所情報
	 */
	@NotEmpty
	@Pattern(regexp = "^[0-9]{3}[0-9]{4}$", message = "郵便番号の形式が間違っています")
	private String postcode;

	@NotEmpty
	@Size(max = 16, message = "入力できる文字数を超過しています。")
	private String prefecture; // 都道府県

	@NotEmpty
	@Size(max = 128, message = "入力できる文字数を超過しています。")
	private String city; // 市区町村

	@NotEmpty
	@Size(max = 128, message = "入力できる文字数を超過しています。")
	private String block; // 番地

	@NotNull
	private int memberId;

	private LocalDate dateNow = LocalDate.now();

	public String getFullName() {
		return this.lastName + this.firstName;
	}

	public String getFullAddress() {
		return this.postcode + this.prefecture + this.city + this.block;
	}

	public Order createOrder() {
		return new Order(this);
	}

}
