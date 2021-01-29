package com.example.training.mobile.controller.product;

import com.example.training.common.domain.Product;

import lombok.Data;

/**
 * 商品のデータ転送用オブジェクト
 */
@Data
public class ProductDTO {
  private int id;
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
    this.id = product.getId();
    this.name = product.getName();
    this.price = product.getPrice().getValue();
    this.description = product.getDescription();
    this.imagePath = product.getImagePath();

  }
  /**
   * この方法で試すと、priceの値が取得できなかったためコメントアウト中。
   *
   * @param product 商品
   */
  // public ProductDTO(Product product) {
  // BeanUtils.copyProperties(product, this);
  // }
}
