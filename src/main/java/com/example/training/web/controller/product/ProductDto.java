package com.example.training.web.controller.product;

import com.example.training.common.domain.CartItem;
import com.example.training.common.entity.ProductEntity;

import org.springframework.beans.BeanUtils;

import lombok.Data;

/**
 * 商品のデータ転送用オブジェクト
 */
@Data
public class ProductDto {
  private int id;
  private String name;
  private int price;
  private String imagePath;

  public ProductDto(CartItem cartItem) {
    this.id = cartItem.getProductId();
    this.name = cartItem.getProductName();
    this.price = cartItem.getProductPrice().getValue();
    this.imagePath = cartItem.getProductImagePath();
  }

  public ProductDto(ProductEntity entity) {
    BeanUtils.copyProperties(entity, this);
  }
}
