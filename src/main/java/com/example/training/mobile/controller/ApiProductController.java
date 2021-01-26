package com.example.training.mobile.controller;

import java.util.List;

import com.example.training.common.repository.ProductRepository;
import com.example.training.web.domain.product.ProductEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ApiProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	// public List<Product> product() {
	public List<ProductEntity> product() {
		List<ProductEntity> productEntities = productRepository.findAll();
		// List<Product> products = new ArrayList<Product>();
		// for (ProductEntity productEntity : productEntities) {
		// 	products.add(new Product(productEntity));
		// }

		return productEntities;
	}

}
