package com.example.training.web.domain.product;

/**
 *
 * 商品の個数を表す値オブジェクト
 *
 */
public class Quantity {

	/**
	 *
	 * 数量の値
	 *
	 */
	private int value;

	/**
	 *
	 * 数量の最小値
	 *
	 */
	private final int MIN = 0;

	/**
	 *
	 * 数量の最大値
	 *
	 */
	private final int MAX = Integer.MAX_VALUE;

	/**
	 *
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public Quantity(int value) {
		if (value < MIN) {
			throw new IllegalArgumentException("数量の最小値を下回っています");
		}
		if (value > MAX) {
			throw new IllegalArgumentException("数量の最大値を超えています");
		}
		this.value = value;
	}

	/**
	 *
	 * 数量を得る。
	 *
	 * @return 数量の値
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 *
	 * 数量を加算する。
	 *
	 * @param quantity 加える値
	 * @return 加算結果
	 */
	public Quantity add(Quantity quantity) {
		int added = this.value + quantity.getValue();
		return new Quantity(added);
	}

	/**
	 *
	 * 数量を減算する。
	 *
	 * @param quantity 引く値
	 * @return 加算結果
	 */
	public Quantity subtract(Quantity quantity) {
		int subtracted = this.value - quantity.getValue();
		if (subtracted < MIN) {
			return new Quantity(0);
		}
		return new Quantity(subtracted);
	}

	/**
	 *
	 * 数量を初期化する。
	 *
	 * @return 新しいインスタンス
	 */
	public Quantity clear() {
		return new Quantity(MIN);
	}

	/**
	 *
	 * 数量がゼロか判定する
	 *
	 * @return 判定結果
	 */
	public Boolean isZero() {
		return this.value == 0;
	}

}
