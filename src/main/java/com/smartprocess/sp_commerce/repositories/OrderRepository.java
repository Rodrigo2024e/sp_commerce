
package com.smartprocess.sp_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartprocess.sp_commerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
