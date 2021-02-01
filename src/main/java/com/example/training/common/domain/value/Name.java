package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 名前を表す値オブジェクト
 */
@Getter
public class Name {
  /**
   * 名前の値
   */
  private String value;
  /**
   * 名前の最大値
   */
  private final int MAX = 16;
  /**
   * 名前の最小値
   */
  private final int MIN = 1;

  /**
   * 基本コンストラクタ
   *
   * @param value
   */
  public Name(String value) {
    Assertion.isNull(value);
    Assertion.length(value, MIN, MAX);

    this.value = value;
  }

}
