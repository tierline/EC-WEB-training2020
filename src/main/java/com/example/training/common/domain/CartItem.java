package com.example.training.common.domain;

import com.example.training.common.domain.value.ImagePath;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.Quantity;
import com.example.training.common.domain.value.id.ProductId;

/**
 * カート内の商品クラス
 */
public class CartItem {
	/**
	 * 商品
	 */
	private Product product;
	/**
	 * 商品の個数
	 */
	private Quantity quantity;

	/**
	 * 基本コンストラクタ
	 *
	 * @param product 商品
	 */
	public CartItem(Product product) {
		this.product = product;
		this.quantity = new Quantity(1);
	}

	/**
	 * 商品数を指定する基本コンストラクタ。
	 *
	 * @param product 商品
	 */
	public CartItem(Product product, Quantity quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * 商品の個数を返す。
	 *
	 * @return 商品数
	 */
	public Quantity getQuantity() {
		return this.quantity;
	}

	/**
	 * 商品数を加算する。
	 *
	 * @param quantity 加算結果
	 */
	public void addQuantity(Quantity quantity) {
		this.quantity = this.quantity.add(quantity);
	}

	/**
	 * 商品の個数を変更する。
	 *
	 * @param quantity 変更後の個数
	 */
	public void changeQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	/**
	 * 商品数をゼロにする。
	 *
	 * @param quantity 個数ゼロの商品
	 */
	public void clearQuantity() {
		this.quantity = quantity.clear();
	}

	/**
	 * 商品の個数がゼロか判定する。
	 *
	 * @return 判定結果
	 */
	public boolean isQuantityZero() {
		return this.quantity.isZero();
	}

	/**
	 * 商品の合計金額を取得する。
	 *
	 * @return 合計金額
	 */
	public Price getTotalPrice() {
		Price totalPrice = this.product.getPrice().multiply(this.getQuantity());
		return totalPrice;
	}

	/**
	 * 商品を取得する。
	 *
	 * @return 商品
	 */
	public Product getProduct() {
		return this.product;
	}

	/**
	 * 商品IDを取得する。
	 *
	 * @return 商品ID
	 */
	public ProductId getProductId() {
		return this.getProduct().getId();
	}

	/**
	 * 商品画像のPATHを取得する。
	 *
	 * @return 商品画像PATH
	 */
	public ImagePath getProductImagePath() {
		return this.getProduct().getImagePath();
	}

	/**
	 * 商品名を取得する。
	 *
	 * @return 商品名
	 */
	public ProductName getProductName() {
		return this.getProduct().getName();
	}

	/**
	 * 商品価格を取得する。
	 *
	 * @return 商品価格
	 */
	public Price getProductPrice() {
		return this.getProduct().getPrice();
	}

	/**
	 * 同じ商品か判定する。
	 *
	 * @param product
	 * @return
	 */
	public boolean equalsProduct(Product product) {
		return getProduct().equals(product);
	}
}
