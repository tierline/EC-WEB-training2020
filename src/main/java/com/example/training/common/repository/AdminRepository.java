package com.example.training.common.repository;

import java.util.Optional;

import com.example.training.common.domain.value.Name;
import com.example.training.common.entity.AdminEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 管理者のリポジトリ
 */
@Mapper
public interface AdminRepository {

  /**
   * 名前で検索する。
   *
   * @param name
   * @return 管理者
   */
  Optional<AdminEntity> findByName(Name name);
}
