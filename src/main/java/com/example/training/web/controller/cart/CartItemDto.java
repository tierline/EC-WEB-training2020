package com.example.training.web.controller.cart;

import com.example.training.web.controller.product.ProductDto;

public class CartItemDto {
  /**
   * 商品
   */
  private ProductDto product;
  /**
   * 商品の個数
   */
  private int quantity;

  // TODO : 作成
  // public CartItemDto(CartItem cartItem) {
  //   // this.product = new ProductDto(cartItem.getProduct());
  //   this.product = new ProductDto(cartItem.getProduct());
  //   this.quantity = cartItem.getQuantity().getValue();
  // }

}
