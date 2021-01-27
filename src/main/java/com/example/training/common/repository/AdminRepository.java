package com.example.training.common.repository;

import java.util.Optional;

import com.example.training.web.domain.admin.Admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {

  Optional<Admin> findByName(String name);
}
