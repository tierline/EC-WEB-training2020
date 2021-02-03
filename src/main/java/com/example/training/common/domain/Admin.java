package com.example.training.common.domain;

import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Name;
import com.example.training.common.domain.value.Role;
import com.example.training.common.domain.value.id.AdminId;
import com.example.training.common.entity.AdminEntity;

import lombok.Getter;

/**
 * 管理者のクラス
 */
@Getter
public class Admin {
	public static final String SESSION_NAME = "ADMIN";

	/**
	 * 管理者ID
	 */
	private AdminId id;

	/**
	 * 名前
	 */
	private Name name;

	/**
	 * パスワード
	 */
	private DigestPassword password;

	/**
	 * 権限
	 */
	private Role roles;

	/**
	 * DBから取得するためのコンストラクタ
	 *
	 * @param entity
	 */
	public Admin(AdminEntity entity) {
		this.id = new AdminId(entity.getId());
		this.name = new Name(entity.getName());
		this.password = new DigestPassword(entity.getPassword());
		this.roles = Role.ROLE_ADMIN;
	}

}
