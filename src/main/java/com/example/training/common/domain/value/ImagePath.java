package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 画像PATHを表す値オブジェクト
 */
public class ImagePath {

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
  public ImagePath(String value) {
    this.value = value;
  }

}
