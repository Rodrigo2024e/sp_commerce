
package com.smartprocess.sp_commerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
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

}
