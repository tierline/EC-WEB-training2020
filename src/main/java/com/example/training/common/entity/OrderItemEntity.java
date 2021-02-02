package com.example.training.common.entity;

import lombok.Getter;

/**
 * 注文商品のDB取得のためのエンティティ Productの違いはとは orderId フィールドの有無
 */
@Getter
public class OrderItemEntity {
  /**
   * 注文ID
   */
  private int orderId;

  /**
   * 商品名
   */
  private String name;

  /**
   * 商品価格
   */
  private int price;

  /**
   * 商品の個数
   */
  private int quantity;

  /**
   * 商品画像のPATH
   */
  private String imagePath;

}
