package com.example.training.common.controller;

import com.example.training.common.domain.Product;
import com.example.training.common.entity.ProductEntity;

import org.springframework.beans.BeanUtils;

import lombok.Getter;

/**
 * 商品のデータ転送用オブジェクト
 */
@Getter
public class ProductDTO {
  private Long id;
  private String name;
  private int price;
  private String description;
  private String imagePath;

  /**
   * 基本コンストラクタ
   *
   * @param product
   */
  public ProductDTO(Product product) {
    this.id = product.getId().getValue();
    this.name = product.getName().getValue();
    this.price = product.getPrice().getValue();
    this.description = product.getDescription().getValue();
    this.imagePath = product.getImagePath().getValue();
  }

  /**
   * 基本コンストラクタ
   *
   * @param product
   */
  public ProductDTO(ProductEntity productEntity) {
    BeanUtils.copyProperties(productEntity, this);
  }

  /**
   * この方法で試すと、priceの値が取得できなかったためコメントアウト中。ネストしたものがうまくいかない模様。
   *
   * @param product 商品
   */
  // public ProductDTO(Product product) {
  // BeanUtils.copyProperties(product, this);
  // }
}
