package com.example.training.web.domain.cart;

import com.example.training.web.domain.product.Price;
import com.example.training.web.domain.product.Product;
import com.example.training.web.domain.product.Quantity;

public class CartItem {
	private Product product;
	private Quantity quantity;

	/**
	 *
	 * 基本コンストラクタ。
	 *
	 * @param product
	 */
	public CartItem(Product product) {
		this.product = product;
		this.quantity = new Quantity(1);
	}

	/**
	 *
	 * 商品数を返す
	 *
	 * @return
	 */
	public Quantity getQuantity() {
		return this.quantity;
	}

	/**
	 *
	 * 商品数と引数を加算する
	 *
	 * @param quantity
	 */
	public void addQuantity(Quantity quantity) {
		this.quantity = this.quantity.add(quantity);
	}

	/**
	 *
	 *
	 * fix: change以外の方法で...。
	 *
	 * @param quantity
	 */
	public void changeQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	/**
	 *
	 * 商品数ゼロにする
	 *
	 * @param quantity
	 */
	public void resetQuantity(Quantity quantity) {
		this.quantity = quantity.clear();
	}

	/**
	 *
	 * 商品の個数がゼロかどうかの判定結果を返す
	 *
	 * @return
	 */
	public boolean isQuantityZero() {
		return this.quantity.isZero();
	}

	/**
	 *
	 * 商品の合計金額を返す
	 *
	 * @return
	 */
	public Price getTotalAmount() {
		// Price totalAmount = this.product.getProductPrice() *
		// this.getQuantity().getValue();
		Price totalAmount = this.product.getPrice().multiply(this.getQuantity());
		return totalAmount;
	}

	/**
	 *
	 * 商品を返す
	 *
	 * @return
	 */

	public Product getProduct() {
		return this.product;
	}

	public int getProductId() {
		return this.getProduct().getId();
	}

	public String getProductImagePath() {
		return this.getProduct().getImagePath();
	}

	public String getProductName() {
		return this.getProduct().getName();
	}

	public Price getProductPrice() {
		return this.getProduct().getPrice();
	}
}
