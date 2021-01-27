package com.example.training.web.domain.product;

import lombok.Data;

/**
 * キャスト用エンティティ（DB取得時）
 */
@Data
public class ProductEntity {
  private int id;
  private String name;
  private int price;
  private String imagePath;
  private String description;
}
