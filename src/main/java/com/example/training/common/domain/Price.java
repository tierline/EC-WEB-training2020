package com.example.training.common.domain;

import org.dom4j.IllegalAddException;

import lombok.Getter;

public class Price {

  // 料金の値
  @Getter
  private int value;

  // 料金の最小値
  private final int MIN = 0;

  public Price(int value) {
    if (value < MIN) {
      throw new IllegalArgumentException("料金の値が最小値を下回っています");
    }
    this.value = value;
  }

  /**
   *
   * 加算可能か判定し、フィールドの数量値と引数の加算結果を返す。
   *
   * @param price
   * @return 加算後の数値
   */
  public Price add(Price price) {
    if (!canAdd(price)) {
      throw new IllegalAddException("不正な値です。加算結果がマイナスです");
    }
    int added = addValue(price);
    return new Price(added);
  }

  /**
   *
   * 加算可能かどうかの判定結果を返す。
   *
   * @param price
   * @return
   */
  private Boolean canAdd(Price price) {
    int added = this.value + price.value;
    return added > MIN;
  }

  /**
   *
   * フィールドの料金の値と引数の加算結果を返す。
   *
   * @param quantity
   * @return
   */
  private int addValue(Price price) {
    return this.value + price.getValue();
  }

  public Price multiply(Quantity quantity) {
    int multiplied = this.value * quantity.getValue();
    return new Price(multiplied);
  }

}
