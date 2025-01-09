
package com.smartprocess.sp_commerce.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartprocess.sp_commerce.dto.CategoryDTO;
import com.smartprocess.sp_commerce.services.CategoryService;


@RestController
@RequestMapping(value = "/categories")

public class CategoryController {
	
	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
