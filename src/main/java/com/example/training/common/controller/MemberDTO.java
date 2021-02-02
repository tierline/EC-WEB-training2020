package com.example.training.common.controller;

import com.example.training.common.domain.Member;
import com.example.training.common.entity.MemberEntity;

import lombok.Getter;

/**
 * 会員のデータ転送用オブジェクト
 */
@Getter
public class MemberDTO {
  private Long memberId;
  private String email;
  private String lastName;
  private String firstName;
  private String phoneNumber;
  private String postcode;
  private String prefecture;
  private String city;
  private String block;

  /**
   * 住所入力フォームに会員情報をセットするためのコンストラクタ
   *
   * @param member
   */
  public MemberDTO(Member member) {
    this.memberId = member.getMemberId().getValue();
    this.email = member.getEmail().getValue();
    this.lastName = member.getFullName().getLastName().getValue();
    this.firstName = member.getFullName().getFirstName().getValue();
    this.phoneNumber = member.getPhoneNumber().getValue();
    this.postcode = member.getAddress().getPostcode().getValue();
    this.prefecture = member.getAddress().getPrefecture().getValue();
    this.city = member.getAddress().getCity().getValue();
    this.block = member.getAddress().getBlock().getValue();
  }

  /**
   * Mobile版の住所フォームのためのコンストラクタ
   *
   * @param memberEntity
   */
  public MemberDTO(MemberEntity memberEntity) {
    this.memberId = memberEntity.getMemberId();
    this.email = memberEntity.getEmail();
    this.lastName = memberEntity.getLastName();
    this.firstName = memberEntity.getFirstName();
    this.phoneNumber = memberEntity.getPhoneNumber();
    this.postcode = memberEntity.getPostcode();
    this.prefecture = memberEntity.getPrefecture();
    this.city = memberEntity.getCity();
    this.block = memberEntity.getBlock();
  }
}
