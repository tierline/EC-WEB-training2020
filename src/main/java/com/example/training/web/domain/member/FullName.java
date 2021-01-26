package com.example.training.web.domain.member;

import lombok.Getter;

public class FullName {
	@Getter
	private String lastName;

	// C: これでもいけるか？
	@Getter
	private String firstName;

	private final int MAX = 5;

	private final int MIN = 1;

	public FullName(String lastName, String firstName) {
		if (lastName == null) {
			throw new IllegalArgumentException("値が入力");
		}
		if (lastName.length() < MIN || lastName.length() > MAX) {
			throw new IllegalArgumentException("値が入力");
		}
		if (firstName == null) {
			throw new IllegalArgumentException("値が入力");
		}
		if (firstName.length() < MIN || firstName.length() > MAX) {
			throw new IllegalArgumentException("値が入力");
		}
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public FullName() {

	}

	/*
	 * フルネームを返す
	 */
	public String getValue() {
		return this.lastName + this.firstName;
	}
}

// 注意
// クラスのコンストラクタとメソッドに全て日本語でコメントを書く。何用のコンストラクタか、何をするメソッドか。
// Serviceクラスでsessionは使わない

// やること
// 値オブジェクト
// 値オブジェクトフォームを切り離す
// 値オブジェクトのバリデーション

// リポジトリ
// リポジトリの名前を統一する（create, update）
// リポジトリにアプリケーション層を持ってこない

// セッション
// セッションの保持する値をID, EMAIL
// 基本的にセッションではなく、DBから取ってくる。（永続化されるかどうか）

// パッケージの構成を整える
// resources のほうも書き換える。xml系。
// web
// controller
// domain
// mobile
// common
// repository
