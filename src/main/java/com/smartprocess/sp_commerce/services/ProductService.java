

package com.smartprocess.sp_commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.smartprocess.sp_commerce.dto.CategoryDTO;
import com.smartprocess.sp_commerce.dto.ProductDto;
import com.smartprocess.sp_commerce.dto.ProductMinDto;
import com.smartprocess.sp_commerce.entities.Category;
import com.smartprocess.sp_commerce.entities.Product;
import com.smartprocess.sp_commerce.repositories.ProductRepository;
import com.smartprocess.sp_commerce.services.exceptions.DataBaseException;
import com.smartprocess.sp_commerce.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDto findById(Long id) {
		Product product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ProductDto(product);
	}
	
	@Transactional(readOnly = true)
	public Page<ProductMinDto> findAll(String name, Pageable pageable) {
		Page<Product> result = repository.searchByName(name, pageable);
		return result.map(x -> new ProductMinDto(x));
	}
	
	@Transactional
	public ProductDto insert(ProductDto dto) {
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProductDto(entity);
	}
	
	@Transactional
	public ProductDto update(Long id, ProductDto dto) {
		
		try {
			Product entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProductDto(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException ("Recurso não encontrado");
		}
		
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		try {
	        	repository.deleteById(id);    		
		}
	    	catch (DataIntegrityViolationException e) {
	        	throw new DataBaseException("Falha de integridade referencial");
	   	}
	}
	
	
	private void copyDtoToEntity(ProductDto dto, Product entity) {
		// TODO Auto-generated method stub
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());
		
		entity.getCategories().clear();
		for (CategoryDTO catDto : dto.getCategories()) {
			Category cat = new Category();
			cat.setId(catDto.getId());
			entity.getCategories().add(cat);
		}
	}

}
