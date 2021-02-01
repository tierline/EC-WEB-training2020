package com.example.training.mobile.controller.cart;

import com.example.training.common.domain.CartItem;

import lombok.Getter;

/**
 * カート内商品の転送用オブジェクト
 */
@Getter
public class CartItemDTO {
  /**
   * 商品の個数
   */
  private int quantity;

  private Long id;
  private String name;
  private int price;
  private String description;
  private String imagePath;

  /**
   * 基本コンストラクタ
   */
  public CartItemDTO(CartItem cartItem) {
    this.id = cartItem.getProductId().getValue();
    this.name = cartItem.getProductName().getValue();
    this.price = cartItem.getProductPrice().getValue();
    this.description = cartItem.getProduct().getDescription().getValue();
    this.imagePath = cartItem.getProductImagePath().getValue();
    this.quantity = cartItem.getQuantity().getValue();
  }
}
