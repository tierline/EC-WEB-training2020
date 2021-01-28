package com.example.training.common.http;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.id.MemberId;

import lombok.Getter;

/**
 * セッションに保存する会員情報のクラス
 */
public class MemberSession {

  /**
   * 会員ID
   */
  @Getter
  private MemberId memberId;
  /**
   * Eメール
   */
  @Getter
  private Email email;

  /**
   * 基本コンストラクタ
   *
   * @param value
   */
  public MemberSession(Member member) {
    MemberId memberId = member.getMemberId();
    Email email = member.getEmail();
    if (memberId == null) {
      throw new NullPointerException();
    }
    if (email == null) {
      throw new NullPointerException();
    }
    this.memberId = memberId;
    this.email = email;
  }

  /**
   * デフォルトコンストラクタ
   */
  public MemberSession() {

  }

}
