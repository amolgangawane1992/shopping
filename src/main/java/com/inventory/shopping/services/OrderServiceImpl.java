package com.inventory.shopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.shopping.model.OrderInfo;
import com.inventory.shopping.repository.OrderInfoRepo;

@Service
public class OrderServiceImpl {

	@Autowired
	private OrderInfoRepo orderInfoRepo;

	public OrderInfo saveOrder(OrderInfo data) {

		return orderInfoRepo.save(data);
	}

	public double totalOrderCost(List<OrderInfo> orderList) {

		double totalAmount = 0;

		for (OrderInfo order : orderList) {
			OrderInfo orderData = orderInfoRepo.findById(order.getOrderId());

				totalAmount = totalAmount + orderData.getPrice();
		}

		return totalAmount;
	}
	
}
