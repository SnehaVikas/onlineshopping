package com.sprint.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.onlineshopping.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
