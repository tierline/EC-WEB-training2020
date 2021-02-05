package com.example.training.repository;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

/**
 * 注文リポジトリのテスト
 */
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestOrderRepository {

  /**
   * 注文処理ができる。
   */
  void testSaveOrder() {
  }
}
