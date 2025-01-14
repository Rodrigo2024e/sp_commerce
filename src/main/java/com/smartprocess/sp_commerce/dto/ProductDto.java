
package com.smartprocess.sp_commerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.smartprocess.sp_commerce.entities.Category;
import com.smartprocess.sp_commerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
	
	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
	@NotBlank(message = "Campo requerido")
	private String name;
	@Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
	@NotBlank(message = "Campo requerido")
	private String description;
	
	@NotNull(message = "O campo deve ser requerido")
	@Positive(message = "O preço deve ser positivo")
	private Double price;
	
	private String imgUrl;
	
	@NotEmpty(message = "Deve haver pelo menos uma categoria")
	private List<CategoryDTO> categories = new ArrayList();

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
		for (Category cat : entity.getCategories()) {
			categories.add(new CategoryDTO(cat));
		}
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


	public Double getPrice() {
        if (price == null || price == 0.0) {
            return null; 
        }
        return price;
    }


	public String getImgUrl() {
		return imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
	
	
	
}
