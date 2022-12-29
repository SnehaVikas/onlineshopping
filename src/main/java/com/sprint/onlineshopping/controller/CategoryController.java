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
import org.springframework.web.bind.annotation.RestController;

import com.sprint.onlineshopping.dto.CategoryDto;
import com.sprint.onlineshopping.exception.CategoryNotFoundException;
import com.sprint.onlineshopping.service.CategoryService;


@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	
	 //add category

    @PostMapping("/category/add")
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto newCategory=categoryService.addCategory(categoryDto);
        ResponseEntity<CategoryDto> responseEntity=new ResponseEntity<>(newCategory,HttpStatus.CREATED);
        return responseEntity;
    }
    
    //get category by name
    
    public ResponseEntity<String> fetchCategoryByName(@PathVariable("name")String categoryName) {
  	  
  	  ResponseEntity<String> responseEntity=null;
        categoryService.getCategoryByName(categoryName);
        responseEntity=new ResponseEntity<>("category deleted",HttpStatus.OK);
        return responseEntity;
    }
    
    //delete category by id

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> removeCategory(@PathVariable("id")int categoryId) throws CategoryNotFoundException{
        ResponseEntity<String> responseEntity=null;
            categoryService.deleteCategory(categoryId);
            responseEntity=new ResponseEntity<>("category deleted",HttpStatus.OK);
        return responseEntity;
    }

  //get category by id

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> fetchCategoryDetails(@PathVariable("id") int categoryId) throws CategoryNotFoundException {
        CategoryDto category=categoryService.getCategoryById(categoryId);
        ResponseEntity<CategoryDto> responseEntity=null;
        if(category!=null) {
            responseEntity=new ResponseEntity<>(category,HttpStatus.OK);
        }
        else {
            responseEntity=new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    
    // view all category 

    @GetMapping("/category/all")
    public List<CategoryDto> fetchAllCategory(){
        List<CategoryDto> list=categoryService.getAllCategory();
        return list;
    }


    
    

}

