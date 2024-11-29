
package com.smartprocess.sp_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartprocess.sp_commerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
