package com.example.training.web.domain.order;

import com.example.training.web.domain.cart.CartItem;
import com.example.training.web.domain.product.Price;
import com.example.training.web.domain.product.Quantity;

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
	private String productName;

	/**
	 * 商品価格
	 */
	private Price productPrice;

	/**
	 * 商品の個数
	 */
	private Quantity productQuantity;

	/**
	 * 商品画像のPATH
	 */
	private String productImagePath;

	/**
	 *
	 * コントラクタ（カート内の商品から注文商品を作る）
	 *
	 * @param item カート内の商品
	 */
	public OrderItem(CartItem item, Order order) {
		this.orderId = new OrderId(order.getId());
		this.productName = item.getProductName();
		this.productPrice = item.getProductPrice();
		this.productQuantity = item.getQuantity();
		this.productImagePath = item.getProductImagePath();
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public OrderItem() {
	}

}
