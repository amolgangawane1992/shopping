package com.inventory.shopping.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.shopping.model.Customer;
import com.inventory.shopping.model.OrderInfo;
import com.inventory.shopping.repository.CustomerRepo;
import com.inventory.shopping.repository.OrderInfoRepo;
import com.inventory.shopping.services.OrderServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
	
	@Autowired
	private OrderInfoRepo orderRepo;
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@GetMapping("/")
	public ResponseEntity<List<OrderInfo>> getAllOrders(){
		
		
		List<OrderInfo> allOrders = orderRepo.findAll();
		
		if(!allOrders.isEmpty())
			return new ResponseEntity(allOrders,HttpStatus.OK);
		else
			return new ResponseEntity(Collections.emptyList(),HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderInfo> getOrder(@PathVariable("orderId") int orderId){
		
		
		OrderInfo orderInfo = orderRepo.findById(orderId);
		
		if(orderInfo != null)
			return new ResponseEntity(orderInfo,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<OrderInfo> deleteOrder(@PathVariable("orderId") int orderId){
		
		
		 orderRepo.deleteById(orderId);
		
			return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<OrderInfo> deleteAllOrders(){
		
		orderRepo.deleteAll();
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<OrderInfo> addOrder(@RequestBody OrderInfo orderInfo){
		
		OrderInfo data = new OrderInfo();
		
		data.setItem(orderInfo.getItem());
		data.setPrice(orderInfo.getPrice());
		data.setStatus(orderInfo.getStatus());
		Optional<Customer> optionalCustomer = custRepo.findById(orderInfo.getCustomer().getCustId());
		if(optionalCustomer.isPresent())
			data.setCustomer(optionalCustomer.get());
		else
			data.setCustomer(orderInfo.getCustomer());
		
		try {
			//OrderInfo savedOrder = orderRepo.save(data);
			OrderInfo savedOrder = orderService.saveOrder(data);
			return new ResponseEntity(savedOrder,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		finally{
			log.info("finall block called");
		}
				
	}
	
//	@PutMapping("/{orderId}")
//	public ResponseEntity<OrderInfo> updateOrderinfo(@PathVariable("orderId") int orderId,
//			@RequestBody OrderInfo data){
//		
//		Optional<OrderInfo> existngOrder = orderRepo.findById(orderId);
//		if(existngOrder.isPresent()) {
//			
//			OrderInfo orderDetails = existngOrder.get();
//			orderDetails.setItem(data.getItem());
//			orderDetails.setPrice(data.getPrice());
//			orderDetails.setStatus(data.getStatus());
//			orderDetails.setCustomer(data.getCustomer());
//			orderRepo.save(orderDetails);
//			return new ResponseEntity(orderDetails,HttpStatus.OK);
//		}else {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//	}
}
