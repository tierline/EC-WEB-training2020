package com.example.training.mobile.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.entity.ProductEntity;
import com.example.training.common.repository.ProductRepository;

/**
 * 商品のコントローラ(Mobile)
 */
@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductControllerAPI {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public List<ProductEntity> product() {
		List<ProductEntity> productEntities = productRepository.findAll();

		return productEntities;
	}

}
