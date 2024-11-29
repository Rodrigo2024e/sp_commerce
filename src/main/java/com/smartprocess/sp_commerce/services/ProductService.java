
package com.smartprocess.sp_commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartprocess.sp_commerce.dto.ProductDto;
import com.smartprocess.sp_commerce.entities.Product;
import com.smartprocess.sp_commerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDto findById(Long id) {
		Product product = repository.findById(id).get();
		return new ProductDto(product);
	}

}
