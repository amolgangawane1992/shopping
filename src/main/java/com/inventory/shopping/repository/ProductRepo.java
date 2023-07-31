package com.inventory.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.shopping.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
