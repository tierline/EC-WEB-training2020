package com.example.training.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.domain.Employee;

@Mapper
public interface UserRepository {

	Optional<Employee> findByEmail(String email);

}
