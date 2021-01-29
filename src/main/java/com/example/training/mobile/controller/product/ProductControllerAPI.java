package com.example.training.mobile.controller.product;

import java.util.List;

import com.example.training.common.entity.ProductEntity;
import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品のコントローラ(Mobile)
 */
@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductControllerAPI {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * 全ての商品を取得する。
	 */
	@GetMapping("/")
	public List<ProductEntity> product() {
		List<ProductEntity> productEntities = productRepository.findAll();

		return productEntities;
	}

}
