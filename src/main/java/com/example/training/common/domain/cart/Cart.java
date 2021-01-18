package com.example.training.common.domain.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.training.common.domain.Product;

public class Cart {
	public static final String SESSION_NAME = "CART";
	private List<CartItem> items = new ArrayList<CartItem>();
	private int totalAmount;

	/**
	 * 商品をカートに追加する
	 *
	 * @param item 商品
	 */
	public void add(Product product) {
		this.add(product, 1);
	}

	/**
	 * 商品をカートに追加する
	 *
	 * @param item
	 * @param quantity
	 */
	public void add(Product product, int quantity) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			itemOpt.get().addQuantity(quantity);
		} else {
			items.add(new CartItem(product));
		}
	}

	/**
	 * カートから商品を1つ削除する
	 *
	 * @param product
	 */
	public void remove(Product product) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			CartItem item = itemOpt.get();
			item.removeQuantity(1);
			if (item.isEmpty()) {
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
			item.removeAll();
			if (item.isEmpty()) {
				this.items.remove(item);
			}
		}
	}

	/**
	 * カート内の商品の数を返す
	 *
	 * @return items.size
	 */
	public int getSize() {
		return items.size();
	}

	/**
	 * カートの中身の取得
	 *
	 * @return
	 */
	public List<CartItem> getItems() {
		return items;
	}

	/**
	 * 商品が存在するか確認
	 *
	 * @param product
	 * @return
	 */
	public Optional<CartItem> getItem(Product product) {
		for (CartItem item : items) {
			int id = item.getProductId();
			if (id == product.getId()) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

	/**
	 * カート内のすべての商品の合計金額を取得
	 *
	 * @return
	 */
	// TOREVIEW 変更
	public int getTotalAmount() {
		this.totalAmount = 0;
		List<CartItem> items = this.getItems();
		for (CartItem item : items) {
			this.totalAmount += item.getTotalAmount();
		}
//		this.totalAmount = new TotalAmount(this.getItems());
		return this.totalAmount;
	}
}
