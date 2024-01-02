package com.middleware.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.middleware.product.model.Product;
import com.middleware.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public String createProduct( @RequestBody Product request) {
		return productService.createProduct(request);
		
	}
	
	@PutMapping
	public String updateProduct( @RequestBody Product request) {
		return productService.updateProduct(request);
		
	}

}
