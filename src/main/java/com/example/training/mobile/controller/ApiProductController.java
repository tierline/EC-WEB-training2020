package com.example.training.mobile.controller;

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
public class ApiProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public List<ProductEntity> product() {
		List<ProductEntity> productEntities = productRepository.findAll();

		return productEntities;
	}

}
