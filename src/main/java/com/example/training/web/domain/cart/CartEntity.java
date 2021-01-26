package com.example.training.web.domain.cart;

import java.util.List;

import lombok.Data;

@Data
public class CartEntity {
  private List<CartItem> items;
  private int totalPrice;
}
