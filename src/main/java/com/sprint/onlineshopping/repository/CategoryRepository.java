package com.sprint.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.onlineshopping.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

	Category findByCategoryName(String categoryName);

}