package com.example.training.mobile.controller.cart;

import com.example.training.common.domain.CartItem;

import lombok.Getter;

@Getter
public class CartItemDTO {
  /**
   * 商品の個数
   */
  private int quantity;

  private int id;
  private String name;
  private int price;
  private String description;
  private String imagePath;

  /**
   * 基本コンストラクタ
   */
  public CartItemDTO(CartItem cartItem) {
    this.id = cartItem.getProductId();
    this.name = cartItem.getProductName();
    this.price = cartItem.getProductPrice().getValue();
    this.description = cartItem.getProduct().getDescription();
    this.imagePath = cartItem.getProductImagePath();
    this.quantity = cartItem.getQuantity().getValue();
  }
}
