package com.sprint.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.onlineshopping.entity.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}