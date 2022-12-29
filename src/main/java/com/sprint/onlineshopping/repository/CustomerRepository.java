package com.sprint.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.onlineshopping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
