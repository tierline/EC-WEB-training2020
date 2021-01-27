package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.web.domain.product.ProductEntity;

/**
 * 商品リポジトリ
 */

@Mapper
public interface ProductRepository {

	/**
	 * 商品IDで商品を取得する。
	 */
	public Optional<ProductEntity> findId(int productId);

	/**
	 * 単語で商品を取得する。
	 *
	 * @param freeWord
	 * @return
	 */
	public List<ProductEntity> findName(String freeWord);

	/**
	 * 全ての商品を取得する。
	 *
	 * @return
	 */
	public List<ProductEntity> findAll();

}
