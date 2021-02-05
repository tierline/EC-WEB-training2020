package com.example.training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Email;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.service.MemberApplicationService;
import com.example.training.web.controller.member.MemberApplicationCommand;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

// @MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class TestMemberApplicationService {

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private MemberApplicationService service;

  /**
   * 会員ができる。
   */
  @Test
  void testRun() {
    Email email = new Email("test99@example.com");
    DigestPassword password = new DigestPassword("test");
    MemberApplicationCommand command = new MemberApplicationCommand();
    command.setEmail(email.getValue());
    command.setPassword(password.getValue());
    service.run(command);

    MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow();

    assertNotNull(memberEntity, "生成できたか");
    assertEquals(email.getValue(), memberEntity.getEmail());
    // TODO 生成した会員をDBから削除
  }

}
