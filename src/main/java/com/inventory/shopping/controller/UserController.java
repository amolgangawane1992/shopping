package com.inventory.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.shopping.model.UserDetails;
import com.inventory.shopping.repositories.UserDetailsRepo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/userDetails")
public class UserController {

	@Autowired
	private UserDetailsRepo userRepo;
	
	
	@PostMapping("/add")
	public ResponseEntity<UserDetails> addUser(@RequestBody UserDetails userData){
		
		UserDetails savedUser = userRepo.save(userData);
		log.info("userData :: "+userData);
		return new ResponseEntity(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDetails>> getAllUsers(){
		
		List<UserDetails> userList = userRepo.findAll();
		
		if(!userList.isEmpty())
			return new ResponseEntity(userList,HttpStatus.OK);
		else
			return new ResponseEntity(userList,HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		
		userRepo.deleteById(userId);
		
	}
	
	@PutMapping("/userId")
	public ResponseEntity<UserDetails> updateUser(@PathVariable("userId") int userId,@RequestBody UserDetails updatedUser){
		
		
		Optional<UserDetails> optUser = userRepo.findById(userId);
		
		if(optUser.isPresent()) {
			UserDetails data = optUser.get();
			data.setUserName(updatedUser.getUserName());
			data.setPassword(updatedUser.getPassword());
			
			return new ResponseEntity(userRepo.save(data),HttpStatus.OK);
		}
		else 
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
}
