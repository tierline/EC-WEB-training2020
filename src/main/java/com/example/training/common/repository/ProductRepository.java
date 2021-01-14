package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import com.example.training.common.domain.Product;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {

	public List<Product> findAll();

	public Optional<Product> findId(int id);

	public List<Product> findName(String word);

}
