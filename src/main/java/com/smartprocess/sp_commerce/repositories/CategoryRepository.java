

package com.smartprocess.sp_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartprocess.sp_commerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
