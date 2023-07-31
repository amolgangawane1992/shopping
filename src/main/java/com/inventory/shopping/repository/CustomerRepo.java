package com.inventory.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.shopping.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
