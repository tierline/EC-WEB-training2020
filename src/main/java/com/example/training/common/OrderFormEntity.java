package com.example.training.common;

import lombok.Data;

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
