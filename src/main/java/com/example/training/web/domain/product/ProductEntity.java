package com.example.training.web.domain.product;

import lombok.Data;

@Data
public class ProductEntity {
  private int id;
  private String name;
  private int price;
  private String imagePath;
  private String description;
}
