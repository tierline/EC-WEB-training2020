package com.example.training.common.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

public class Date {
  @Getter
  private String value;

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public Date(LocalDateTime dateAndTime) {
    this.value = dateAndTime.format(formatter);
  }

}
