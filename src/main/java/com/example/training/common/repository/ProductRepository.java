package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.domain.Product;

@Mapper
public interface ProductRepository {

	public List<Product> findAll();

	public Optional<Product> findId(int id);

	public List<Product> findName(String word);

}
