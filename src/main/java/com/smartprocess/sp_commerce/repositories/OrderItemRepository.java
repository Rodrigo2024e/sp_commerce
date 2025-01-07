
package com.smartprocess.sp_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartprocess.sp_commerce.entities.OrderItem;
import com.smartprocess.sp_commerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	

}
