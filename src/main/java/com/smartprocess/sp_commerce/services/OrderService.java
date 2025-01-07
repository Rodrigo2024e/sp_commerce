

package com.smartprocess.sp_commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartprocess.sp_commerce.dto.OrderDTO;
import com.smartprocess.sp_commerce.entities.Order;
import com.smartprocess.sp_commerce.repositories.OrderRepository;
import com.smartprocess.sp_commerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new OrderDTO(order);
	}
}
