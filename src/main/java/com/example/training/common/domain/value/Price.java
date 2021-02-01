package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 商品価格を表す値オブジェクト
 */
public class Price {

  /**
   * 価格
   */
  @Getter
  private int value;

  /**
   * 価格の最小値
   */
  private final int MIN = 0;

  /**
   * 価格の最大値
   */
  private final int MAX = Integer.MAX_VALUE;

  /**
   * 基本コンストラクタ
   *
   * @param price 価格
   */
  public Price(int price) {
    Assertion.range(value, MIN, MAX);

    this.value = price;
  }

  /**
   * 加算する。
   *
   * @param price 価格
   * @return 加算結果
   */
  public Price add(Price price) {
    int added = this.value + price.getValue();
    return new Price(added);
  }

  /**
   * 数量で乗算する。
   *
   * @param quantity 数量
   * @return 乗算結果
   */
  public Price multiply(Quantity quantity) {
    int multiplied = this.value * quantity.getValue();
    return new Price(multiplied);
  }

}
