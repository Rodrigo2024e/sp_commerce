
package com.smartprocess.sp_commerce.dto;

import com.smartprocess.sp_commerce.entities.Product;

public class ProductDto {
	
	private Long id;
	private String name;
	private String description;
	private double price;
	private String imgUrl;
	
	
	public ProductDto() {
		
	}


	public ProductDto(Long id, String name, String description, double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductDto(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public double getPrice() {
		return price;
	}


	public String getImgUrl() {
		return imgUrl;
	}
	
	
}
