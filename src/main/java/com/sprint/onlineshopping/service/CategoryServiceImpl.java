package com.sprint.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.onlineshopping.dto.CategoryDto;
import com.sprint.onlineshopping.entity.Category;
import com.sprint.onlineshopping.exception.CategoryNotFoundException;
import com.sprint.onlineshopping.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		
		Category category = new Category();
		category.setCategoryName(categoryDto.getCategoryName());
		
		Category newCategory = categoryRepository.save(category);
		
		categoryDto.setCategoryId(newCategory.getCategoryId());
		
		return categoryDto;
	}

	@Override
	public CategoryDto getCategoryById(int categoryId) throws CategoryNotFoundException {
	
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("Category not existing with id: "+categoryId);
		}
		Category category = optionalCategory.get();
		
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());
		
		return categoryDto;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
		return null;
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		 Category category=categoryRepository.findByCategoryName(categoryName);
		return category;
	}
	
	
		
		@Override
		public void deleteCategory(int categoryId) throws CategoryNotFoundException {
			Optional<Category>optionalCategory= categoryRepository.findById(categoryId);
	        if(optionalCategory.isEmpty()) {
	            throw new CategoryNotFoundException("category not found with id :"+categoryId);
	        }
	        categoryRepository.deleteById(categoryId); 
			
		}
	}


