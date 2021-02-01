package com.example.training.common.domain;

import com.example.training.common.domain.value.ImagePath;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.Quantity;
import com.example.training.common.domain.value.id.OrderId;

import lombok.Data;

/**
 * 注文商品クラス
 */
@Data
public class OrderItem {

	/**
	 * 注文ID
	 */
	private OrderId orderId;

	/**
	 * 商品名
	 */
	private ProductName name;

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
	private ImagePath imagePath;

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
