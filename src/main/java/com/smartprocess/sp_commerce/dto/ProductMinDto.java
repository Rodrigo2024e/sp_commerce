
package com.smartprocess.sp_commerce.dto;

import com.smartprocess.sp_commerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDto {
	
	private Long id;
	private String name;
	private double price;
	private String imgUrl;

	public ProductMinDto(Long id, String name, double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductMinDto(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public String getImgUrl() {
		return imgUrl;
	}
	
	
}
