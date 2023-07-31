package com.inventory.shopping.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inventory.shopping.model.Customer;
import com.inventory.shopping.model.OrderInfo;
import com.inventory.shopping.repository.OrderInfoRepo;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

	@Mock
	private OrderInfoRepo orderRepoMock;
	
	@InjectMocks
	private OrderServiceImpl orderService;
	
	@Test
	void testSaveOrder() {
		//System.out.println("Not yet implemented");
		 OrderInfo order1 = new OrderInfo(101,"pendrive",100,"test",new Customer());
		 OrderInfo order2 = new OrderInfo(102,"mouse",400,"test",new Customer());
		 
		 when(orderRepoMock.findById(101)).thenReturn(order1);
		 when(orderRepoMock.findById(102)).thenReturn(order2);
		 
		 List<OrderInfo> orderList = new ArrayList<>();
		 orderList.add(order1);
		 orderList.add(order2);
		 
		 double total = orderService.totalOrderCost(orderList);
		
		 assertEquals(500, total);
		
	}

}
