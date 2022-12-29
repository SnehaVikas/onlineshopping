package com.sprint.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.onlineshopping.dto.ProductDto;
import com.sprint.onlineshopping.entity.Category;
import com.sprint.onlineshopping.entity.Product;
import com.sprint.onlineshopping.exception.ProductNotFoundException;
import com.sprint.onlineshopping.exception.ResourceNotFoundException;
import com.sprint.onlineshopping.repository.CategoryRepository;
import com.sprint.onlineshopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductDto saveProduct(int categoryId, ProductDto productDto) {
		
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new ResourceNotFoundException("Category not existing with id: "+categoryId);
		}
		Category category = optionalCategory.get();
		
		Product product = new Product();
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		product.setCategory(category);
		
		Product newProduct = productRepository.save(product);

		productDto.setProductId(newProduct.getProductId());
		return productDto;
	}

	@Override
	public ProductDto getProductById(int productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not existing with id: "+productId);
		}
		Product product = optionalProduct.get();
		
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setProductPrice(product.getProductPrice());
		
		return productDto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productRepository.findAll();
		
		List<ProductDto> productDtos = new ArrayList<>();
		
		products.forEach(p-> {
			ProductDto pDto = new ProductDto();
			pDto.setProductId(p.getProductId());
			pDto.setProductName(p.getProductName());
			pDto.setProductPrice(p.getProductPrice());
			
			productDtos.add(pDto);
		});
		
		return productDtos;
	}
	
	@Override

	public void deleteProduct(int product) throws ProductNotFoundException {
		Optional<Product>optionalProduct= productRepository.findById(product);
		if(optionalProduct.isEmpty()) 
		{
			throw new ProductNotFoundException("product not found with id :"+product);
		
		}
		productRepository.deleteById(product);

	}

}
