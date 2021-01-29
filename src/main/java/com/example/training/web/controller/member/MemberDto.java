package com.example.training.web.controller.member;

import com.example.training.common.domain.Member;

import lombok.Getter;

/**
 * 会員のデータ転送用オブジェクト
 */
@Getter
public class MemberDto {
  private Long memberId;
  private String email;
  private String password;
  private String lastName;
  private String firstName;
  private String phoneNumber;
  private String postcode;
  private String prefecture;
  private String city;
  private String block;
  private String status;
  private String lastUpdate;
  private String roles = "ROLE_USER";

  /**
   * 住所入力フォームに会員情報をセットするためのコンストラクタ
   *
   * @param member
   */
  public MemberDto(Member member) {
    this.memberId = member.getMemberId().getValue();
    this.email = member.getEmail().getValue();
    this.password = member.getDigestPassword().getValue();
    this.lastName = member.getFullName().getLastName().getValue();
    this.firstName = member.getFullName().getFirstName().getValue();
    this.phoneNumber = member.getPhoneNumber().getValue();
    this.postcode = member.getAddress().getPostcode().getValue();
    this.prefecture = member.getAddress().getPrefecture().getValue();
    this.city = member.getAddress().getCity().getValue();
    this.block = member.getAddress().getBlock().getValue();

    this.status = member.getStatus();
    this.lastUpdate = member.getLastUpdate();
    this.roles = member.getRoles();
  }
}
