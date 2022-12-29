package com.sprint.onlineshopping.service;

import java.util.List;

import com.sprint.onlineshopping.dto.ProductDto;
import com.sprint.onlineshopping.exception.ProductNotFoundException;

public interface ProductService {
	
	public List<ProductDto> getAllProducts();
	ProductDto saveProduct(int categoryId, ProductDto productDto);
	ProductDto getProductById(int productId);
	void deleteProduct(int product) throws ProductNotFoundException; 

}