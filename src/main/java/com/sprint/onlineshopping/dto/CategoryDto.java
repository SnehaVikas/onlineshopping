package com.sprint.onlineshopping.dto;

import javax.validation.constraints.NotNull;

public class CategoryDto {

	private int categoryId;	
	
	private String categoryName;
	@NotNull(message = "Category Name is required")
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}	
}
