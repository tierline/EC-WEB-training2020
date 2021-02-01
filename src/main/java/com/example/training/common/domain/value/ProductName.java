package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 商品名を表す値オブジェクト
 */
public class ProductName {

  /**
   * 画像PATHの値
   */
  @Getter
  public String value;

  /**
   * 基本コンストラクタ
   *
   * @param value
   */
  public ProductName(String value) {
    this.value = value;
  }
}
