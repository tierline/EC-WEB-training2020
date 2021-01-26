package com.example.training.web.domain.order;

import lombok.Data;

/**
 * キャスト用の住所入力エンティティ
 */
@Data
public class OrderFormEntity {
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String postcode;
  private String prefecture;
  private String city;
  private String block;
}
