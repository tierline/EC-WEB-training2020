package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 商品説明を表す値オブジェクト
 */
public class Description {

  /**
   * 商品説明の値
   */
  @Getter
  public String value;

  /**
   * 基本コンストラクタ
   *
   * @param value
   */
  public Description(String value) {
    Assertion.isNull(value);
    this.value = value;
  }

}
