package com.sprint.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.onlineshopping.dto.ProductDto;
import com.sprint.onlineshopping.exception.ProductNotFoundException;
import com.sprint.onlineshopping.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public List<ProductDto> fetchAllProducts() {
		List<ProductDto> list = productService.getAllProducts();
		return list;
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> fetchProductDetails(@PathVariable("productId") int productId) {
		ProductDto productDto = productService.getProductById(productId);
		ResponseEntity<ProductDto> responseEntity = new ResponseEntity<>(productDto, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/{categoryId}/save")
	public ResponseEntity<ProductDto> addProduct(@Valid @PathVariable("categoryId") int categoryId,@RequestBody ProductDto productDto) {
		ProductDto newProduct = productService.saveProduct(categoryId, productDto);
		ResponseEntity<ProductDto> responseEntity = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> removeProduct(@PathVariable("id")int prouctId) throws ProductNotFoundException {
		ResponseEntity<String> responseEntity=null;
		productService.deleteProduct(prouctId);
		responseEntity=new ResponseEntity<>("product deleted",HttpStatus.OK);
		return responseEntity;
	}
}
