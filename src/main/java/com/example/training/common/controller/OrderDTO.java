package com.example.training.common.controller;

import java.time.format.DateTimeFormatter;

import com.example.training.common.domain.Order;

import lombok.Getter;

/**
 * 注文のデータ転送用オブジェクト
 */
@Getter
public class OrderDTO {
  /**
   * 注文ID
   */
  private Long id;
  /**
   * 会員ID
   */
  private Long memberId;
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
  private String orderDateAndTime;

  // TODO: これでやりたいが現状nullになる
  // public OrderDTO(Order order) {
  // BeanUtils.copyProperties(order, this);
  // }

  /**
   * 注文内容から生成するためのコンストラクタ
   *
   * @param order
   */
  public OrderDTO(Order order) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh時mm分ss秒");
    this.id = order.getId().getValue();
    this.memberId = order.getMemberId().getValue();
    this.fullName = order.getFullName().getValue();
    this.address = order.getAddress().getValue();
    this.email = order.getEmail().getValue();
    this.phoneNumber = order.getPhoneNumber().getValue();
    this.totalPrice = order.getTotalPrice().getValue();
    this.orderDateAndTime = order.getOrderDateAndTime().format(formatter);
  }

}
