package com.example.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MEMO: training/app 配下に入れると現状うまくいかない。
 */
@SpringBootApplication
public class TrainingApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrainingApplication.class, args);
    System.out.println("OK!!");
  }

}
