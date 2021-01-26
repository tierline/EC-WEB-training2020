package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import com.example.training.web.domain.product.ProductEntity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {

	public List<ProductEntity> findAll();

	public Optional<ProductEntity> findId(int id);

	public List<ProductEntity> findName(String word);

}
