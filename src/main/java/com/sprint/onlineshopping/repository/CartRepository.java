package com.sprint.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.onlineshopping.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}

