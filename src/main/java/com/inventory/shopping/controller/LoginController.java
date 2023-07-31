package com.inventory.shopping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.shopping.model.UserDetails;
import com.inventory.shopping.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginController {

	@Autowired
	private UserService userServices;
	
	@PostMapping("/login")
	public ResponseEntity<UserDetails> doLogin(@RequestBody UserDetails loginData){
		log.info("in the controller = "+loginData);
		UserDetails validUser = userServices.userExist(loginData);
		
		return new ResponseEntity(validUser, HttpStatus.OK);
	}
	
	
}
