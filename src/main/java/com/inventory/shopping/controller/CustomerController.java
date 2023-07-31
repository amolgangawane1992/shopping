package com.inventory.shopping.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.shopping.model.Customer;
import com.inventory.shopping.repository.CustomerRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepo custRepo;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		List<Customer> allCustomers= custRepo.findAll();
		
		if(!allCustomers.isEmpty())
			return new ResponseEntity(allCustomers,HttpStatus.OK);
		else
			return new ResponseEntity(Collections.emptyList(),HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<List<Customer>> deleteAllCustomer(){
		
		custRepo.deleteAll();
		
		return new ResponseEntity(Collections.emptyList(),HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer newCustomer){
		
		Customer data = new Customer();
		
		data.setName(newCustomer.getName());
		data.setAge(newCustomer.getAge());
		data.setCity(newCustomer.getCity());
		data.setOrderList(newCustomer.getOrderList());
		
		Customer savedData = custRepo.save(data);
		if(savedData != null)
			return new ResponseEntity(savedData,HttpStatus.CREATED);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
