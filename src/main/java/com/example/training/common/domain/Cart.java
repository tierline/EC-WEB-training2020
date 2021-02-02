package com.example.training.common.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.Quantity;

import lombok.Getter;

/**
 * カートクラス
 */
public class Cart {
	public static final String SESSION_NAME = "CART";

	/**
	 * カート内の商品
	 */
	@Getter
	private List<CartItem> items = new ArrayList<CartItem>();

	/**
	 * カート内の商品の合計金額
	 */
	private Price totalPrice = new Price(0);

	/**
	 * 商品を1つ追加する。
	 *
	 * @param item 商品
	 */
	public void add(Product product) {
		this.add(product, new Quantity(1));
	}

	/**
	 * 商品を複数追加する。
	 *
	 * @param item     商品
	 * @param quantity 商品数
	 */
	public void add(Product product, Quantity quantity) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			itemOpt.get().addQuantity(quantity);
		} else {
			items.add(new CartItem(product));
		}
	}

	/**
	 * 商品の個数を変更する。
	 *
	 * @param product  商品
	 * @param quantity 商品数
	 */
	public void changeItemQuantity(Product product, Quantity quantity) {
		CartItem item = getItem(product).orElseThrow(NullPointerException::new);
		item.changeQuantity(quantity);
		if (item.isQuantityZero()) {
			this.items.remove(item);
		}
	}

	/**
	 * 商品のうち1つを削除する。
	 *
	 * @param product 商品
	 */
	public void remove(Product product) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			CartItem item = itemOpt.get();
			item.clearQuantity();
			if (item.isQuantityZero()) {
				this.items.remove(item);
			}
		}
	}

	/**
	 *
	 * 商品の数を取得する。
	 *
	 * @return 商品数
	 */
	public int getSize() {
		return items.size();
	}

	/**
	 * 商品を取得する。
	 *
	 * @param product
	 * @return
	 */
	public Optional<CartItem> getItem(Product product) {
		for (CartItem item : items) {
			if (item.equalsProduct(product))
				return Optional.of(item);
		}
		return Optional.empty();
	}

	/**
	 * 商品の合計金額を取得する。
	 *
	 * @return 合計金額
	 */
	// TOREVIEW 変更
	public Price getTotalPrice() {
		// fix 毎回 method が呼ばれて再計算している
		this.totalPrice = new Price(0);
		List<CartItem> items = this.getItems();
		for (CartItem item : items) {
			this.totalPrice = this.totalPrice.add(item.getTotalPrice());
		}
		return this.totalPrice;
	}
}
