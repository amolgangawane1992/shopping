package com.inventory.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.inventory.shopping.model.OrderInfo;

//@RepositoryRestResource(path="orderInfo")
public interface OrderInfoRepo extends JpaRepository<OrderInfo, Integer>{

	public OrderInfo findById(int orderId);
}
