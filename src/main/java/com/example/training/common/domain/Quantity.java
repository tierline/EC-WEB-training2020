package com.example.training.common.domain;

import org.dom4j.IllegalAddException;

public class Quantity {

	// 数量の値
	private int value;

	// 数量の最小値
	private final int MIN = 0;

	/**
	 *
	 * 通常のコンストラクタ
	 *
	 * @param value
	 */
	public Quantity(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	/**
	 *
	 * 加算可能か判定し、フィールドの数量値と引数の加算結果を返す。
	 *
	 * @param quantity
	 * @return 加算後の数値
	 */
	public Quantity add(Quantity quantity) {
		if (!canAdd(quantity)) {
			throw new IllegalAddException("不正な値です。加算結果がマイナスです");
		}
		int added = addValue(quantity);
		return new Quantity(added);
	}

	/**
	 *
	 * 加算可能かどうかの判定結果を返す。
	 *
	 * @param quantity
	 * @return
	 */
	private Boolean canAdd(Quantity quantity) {
		int added = addValue(quantity);
		return added > MIN;
	}

	/**
	 *
	 * フィールドの数量値と引数の加算結果を返す。
	 *
	 * @param quantity
	 * @return
	 */
	private int addValue(Quantity quantity) {
		return this.value + quantity.value;
	}

	/**
	 *
	 * 減算可能か判定し、フィールドの数量値と引数の減算結果を返す。
	 *
	 * @param quantity
	 * @return 減算後の数値
	 */
	public Quantity subtract(Quantity quantity) {
		if (!canSubtract(quantity)) {
			throw new IllegalAddException("不正な値です。減算結果がマイナスです");
		}
		int removed = subtractValue(quantity);
		return new Quantity(removed);
	}

	/**
	 *
	 * 減算可能かどうかの判定結果を返す。
	 *
	 * @param quantity
	 * @return
	 */
	private Boolean canSubtract(Quantity quantity) {
		int removed = subtractValue(quantity);
		return removed >= MIN;
	}

	/**
	 *
	 * フィールドの数量値と引数の減算結果を返す。
	 *
	 * @param quantity
	 * @return
	 */
	private int subtractValue(Quantity quantity) {
		return this.value - quantity.value;
	}

	/**
	 * 数量値ゼロの新しいインスタンスを返す。
	 */
	public Quantity reset() {
		return new Quantity(MIN);
	}

	/**
	 *
	 * 数量がゼロかどうか判定する
	 *
	 * @return
	 */
	public Boolean isZero() {
		return this.value == MIN;
	}

}
