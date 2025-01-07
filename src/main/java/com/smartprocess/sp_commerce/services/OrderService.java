

package com.smartprocess.sp_commerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartprocess.sp_commerce.dto.OrderDTO;
import com.smartprocess.sp_commerce.dto.OrderItemDTO;
import com.smartprocess.sp_commerce.entities.Order;
import com.smartprocess.sp_commerce.entities.OrderItem;
import com.smartprocess.sp_commerce.entities.OrderStatus;
import com.smartprocess.sp_commerce.entities.Product;
import com.smartprocess.sp_commerce.entities.User;
import com.smartprocess.sp_commerce.repositories.OrderItemRepository;
import com.smartprocess.sp_commerce.repositories.OrderRepository;
import com.smartprocess.sp_commerce.repositories.ProductRepository;
import com.smartprocess.sp_commerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserService userService;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		
		Order order = new Order();
		
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		
		User user = userService.authenticated();
		order.setClient(user);
		
		for (OrderItemDTO itemDto : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDto.getProductId());
			OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
			order.getItems().add(item);
		}
		
		repository.save(order);
		orderItemRepository.saveAll(order.getItems());
		
		return new OrderDTO(order);
	}
}
