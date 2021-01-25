package com.example.training.common.domain.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.training.common.domain.Price;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.Quantity;

public class Cart {
	public static final String SESSION_NAME = "CART";
	private List<CartItem> items = new ArrayList<CartItem>();
	private Price totalAmount = new Price(0);

	/**
	 *
	 * カートに商品を1つ追加する
	 *
	 * @param item 商品
	 */
	public void add(Product product) {
		this.add(product, new Quantity(1));
	}

	/**
	 *
	 * カートに商品を引数個分、追加する
	 *
	 * @param item
	 * @param quantity
	 */
	public void add(Product product, Quantity quantity) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			itemOpt.get().addQuantity(quantity);
		} else {
			items.add(new CartItem(product));
		}
	}

	public void changeItemQuantity(Product product, Quantity quantity) {
		CartItem item = getItem(product).orElseThrow();
		item.changeQuantity(quantity);
		if (item.isQuantityZero()) {
			this.items.remove(item);
		}
	}

	/**
	 *
	 * カートから商品を1つ削除する
	 *
	 * @param product
	 */
	public void remove(Product product) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			CartItem item = itemOpt.get();
			item.resetQuantity(new Quantity(0));
			;
			if (item.isQuantityZero()) {
				this.items.remove(item);
			}
		}
	}

	/**
	 * カートの特定の商品をすべて取り除く
	 *
	 * @param product
	 */
	public void removeAll(Product product) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			CartItem item = itemOpt.get();
			item.resetQuantity(new Quantity(0));
			if (item.isQuantityZero()) {
				this.items.remove(item);
			}
		}
	}

	/**
	 *
	 * カート内の商品の数を返す
	 *
	 * @return items.size
	 */
	public int getSize() {
		return items.size();
	}

	/**
	 *
	 * カート内の商品を取得する
	 *
	 * @return
	 */
	public List<CartItem> getItems() {
		return items;
	}

	/**
	 *
	 * 商品が存在するか確認する
	 *
	 * @param product
	 * @return
	 */
	public Optional<CartItem> getItem(Product product) {
		for (CartItem item : items) {
			int id = item.getProduct().getId();
			if (id == product.getId()) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

	/**
	 *
	 * カート内のすべての商品の合計金額を取得する
	 *
	 * @return
	 */
	// TOREVIEW 変更
	public Price getTotalAmount() {
		// fix 毎回 getTotalAmount が呼ばれて再計算している
		this.totalAmount = new Price(0);
		List<CartItem> items = this.getItems();
		for (CartItem item : items) {
			this.totalAmount = this.totalAmount.add(item.getTotalAmount());
		}
		return this.totalAmount;
	}
}
