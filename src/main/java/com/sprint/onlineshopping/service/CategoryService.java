package com.sprint.onlineshopping.service;

import java.util.List;

import com.sprint.onlineshopping.dto.CategoryDto;



/*public interface CategoryService {

	public CategoryDto saveCategory(CategoryDto categoryDto); 
	public CategoryDto getCategoryById(long categoryId); 
	public List<CategoryDto> getAllCategory(); 
}*/


import com.sprint.onlineshopping.entity.Category;
import com.sprint.onlineshopping.exception.CategoryNotFoundException;


public interface CategoryService {
	
	public CategoryDto addCategory(CategoryDto categoryDto);
	
	public Category getCategoryByName(String categoryName);
	
	public void deleteCategory(int categoryId) throws CategoryNotFoundException;
	
	public CategoryDto getCategoryById(int categoryId) throws CategoryNotFoundException;
	
	 public List<CategoryDto> getAllCategory();
	
	

}
