package com.example.training.web.controller.cart;

import java.util.List;

/**
 * カートのデータ転送用オブジェクト fix :まだ未使用です...。
 */
public class CartDTO {
	private List<CartItemDto> items;
	private int totalPrice;

	// TODO DTOを作成する
	// public CartDto(Cart cart) {
	// List<CartItemDto> list = new List<CartItemDto>();
	// cart.getItem(product)
	// this.items = this.totalPrice = cart.getTotalPrice().getValue();
	// }
}
