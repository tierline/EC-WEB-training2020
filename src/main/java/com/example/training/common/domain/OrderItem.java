package com.example.training.common.domain;

import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.Quantity;

import lombok.Data;
import lombok.Getter;

/**
 * 注文商品クラス
 */
@Data
public class OrderItem {

	/**
	 * 注文ID
	 */
	@Getter
	private int orderId;

	/**
	 * 商品名
	 */
	private String name;

	/**
	 * 商品価格
	 */
	private Price price;

	/**
	 * 商品の個数
	 */
	private Quantity quantity;

	/**
	 * 商品画像のPATH
	 */
	private String imagePath;

	/**
	 *
	 * コントラクタ（カート内の商品から注文商品を作る）
	 *
	 * @param item カート内の商品
	 */
	public OrderItem(CartItem item, Order order) {
		this.orderId = order.getId();
		this.name = item.getProductName();
		this.price = item.getProductPrice();
		this.quantity = item.getQuantity();
		this.imagePath = item.getProductImagePath();
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public OrderItem() {
	}

}
