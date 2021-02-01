package com.example.training.common.entity;

import lombok.Data;

/**
 * キャスト用エンティティ（DB取得時）
 */
@Data
public class ProductEntity {
    private Long id;
    private String name;
    private int price;
    private String imagePath;
    private String description;
}
