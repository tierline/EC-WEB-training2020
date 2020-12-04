package com.example.training.member.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.member.domain.Product;

@Mapper
public interface ProductRepository {

	public List<Product> findAll();

	Optional<Product> findId(int id);

	public List<Product> findIdList(ArrayList<Integer> id);

	public List<Product> findName(String word);

}