package com.example.training.web.domain.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

/**
 * 日時クラス
 */
public class Date {

  /**
   * 日時の値
   */
  @Getter
  private String value;

  /**
   * フォーマッタ
   */
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  /**
   * 基本コンストラクタ。
   *
   * @param dateAndTime
   */
  public Date(LocalDateTime dateAndTime) {
    this.value = dateAndTime.format(formatter);
  }

}
