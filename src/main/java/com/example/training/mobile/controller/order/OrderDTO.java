package com.example.training.mobile.controller.order;

import com.example.training.common.domain.Order;
import com.example.training.common.domain.value.Date;

import lombok.Getter;

/**
 * 注文のデータ転送用オブジェクト
 */
@Getter
public class OrderDTO {
  /**
   * 注文ID
   */
  private int id;
  /**
   * 会員ID
   */
  private int memberId;
  /**
   * 会員の氏名
   */
  private String fullName;
  /**
   * 会員の住所
   */
  private String address;
  /**
   * 会員のEメールアドレス
   */
  private String email;
  /**
   * 会員の電話番号
   */
  private String phoneNumber;
  /**
   * 注文合計金額
   */
  private int totalPrice;
  /**
   * 注文日時
   */
  private Date orderDateAndTime;

  // TODO: これでやりたいが現状nullになる
  // public OrderDTO(Order order) {
  // BeanUtils.copyProperties(order, this);
  // }

  public OrderDTO(Order order) {
    this.id = order.getId();
  }

}
