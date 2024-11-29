
package com.smartprocess.sp_commerce.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartprocess.sp_commerce.dto.ProductDto;
import com.smartprocess.sp_commerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")

public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ProductDto findById(@PathVariable Long id) {
	return service.findById(id);

	}

	@GetMapping
	public Page<ProductDto> findAll(Pageable pageable) {
	return service.findAll(pageable);

	}
}
