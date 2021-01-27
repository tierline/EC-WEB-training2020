package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.web.domain.product.ProductEntity;

@Mapper
public interface ProductRepository {

	public List<ProductEntity> findAll();

	public Optional<ProductEntity> findId(int id);

	public List<ProductEntity> findName(String word);

}
