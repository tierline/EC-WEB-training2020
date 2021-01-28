package com.example.training.common.domain.value;

public class Assertion {

  public static void isNull(String value) {
    assert (value == null);
  }

  public static void isNull(String value1, String value2) {
    isNull(value1);
    isNull(value2);
  }

  public static void length(String value, int min, int max) {
    assert (value.length() < min || value.length() > max);
  }

  public static void length(String value1, String value2, int min, int max) {
    length(value1, min, max);
    length(value2, min, max);
  }

}
