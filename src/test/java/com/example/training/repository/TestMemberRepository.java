package com.example.training.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.MemberStatus;
import com.example.training.common.domain.value.id.MemberId;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.repository.MemberRepository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

/**
 * 会員リポジトリのテスト
 */
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestMemberRepository {

  @Autowired
  private MemberRepository memberRepository;

  /**
   * IDで取得できる。
   */
  @Test
  void testFindById() {
    var id = new MemberId(1L);
    var memberEntityOpt = memberRepository.findById(id);

    assertTrue(memberEntityOpt.isPresent(), "取得できたか");
    assertEquals(id.getValue(), memberEntityOpt.get().getMemberId(), "IDの照合");
  }

  /**
   * Eメールで取得できる。
   */
  @Test
  void testFindByEmail() {
    var email = new Email("test@example.com");
    var memberEntityOpt = memberRepository.findByEmail(email);

    assertTrue(memberEntityOpt.isPresent(), "取得できたか");
    assertEquals(email.getValue(), memberEntityOpt.get().getEmail(), "Emailの照合");
  }

  /**
   * 会員が保存できる。
   */
  @Test
  void testSave() {
    var email = new Email("test@test.com");
    var password = new DigestPassword("test");
    var status = MemberStatus.UNAPPROVED;
    var entity = new MemberEntity(email, password, status);
    memberRepository.save(entity);
    var memberEntityOpt = memberRepository.findByEmail(email);

    assertTrue(memberEntityOpt.isPresent(), "取得できたか");
    assertEquals(email.getValue(), memberEntityOpt.get().getEmail(), "emailの照合");
    assertEquals(password.getValue(), memberEntityOpt.get().getPassword(), "passwordの照合");
    assertEquals(status, memberEntityOpt.get().getStatus(), "statusの照合");
  }

}
