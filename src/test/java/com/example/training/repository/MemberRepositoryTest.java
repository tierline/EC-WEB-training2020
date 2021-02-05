package com.example.training.repository;

// 保存時 * でも。static。
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Email;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.repository.MemberRepository;
import com.example.training.web.controller.member.MemberApplicationCommand;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @ContextConfiguration(classes =
// com.example.training.RepositoryTestConfig.class)
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  /**
   * 会員インスタンスが生成できる。
   */
  @Test
  void testCreate() {
    Member member = new Member();

    assertNotNull(member);
  }

  // domain, repository(主にSQL), service
  // TODO 複数のドメインにまたがる操作、サービス。
  // マスターは別かも。
  /**
   * 会員ができる。
   */
  @Test
  void testSaveMember() {
    Email email = new Email("test99@example.com");
    DigestPassword password = new DigestPassword("test");
    MemberApplicationCommand command = new MemberApplicationCommand();
    command.setEmail(email.getValue());
    Member member = command.createMember(password);
    MemberEntity entity = new MemberEntity(member);

    memberRepository.save(entity);
    MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow();
    // Assertions -> STATIC import
    assertEquals(memberEntity, memberRepository.findByEmail(email));
    assertEquals("test99@example.com", memberEntity.getEmail());
  }

  /**
   * Eメールで取得できる。
   */
  @Test
  void testFindByEmail() {
    Email email = new Email("test@example.com");
    var memberEntityOpt = memberRepository.findByEmail(email); // テストの場合、型なしでも良い。
    assertTrue(memberEntityOpt.isPresent());

    assertEquals(email.getValue(), memberEntityOpt.get().getEmail());
  }

}
