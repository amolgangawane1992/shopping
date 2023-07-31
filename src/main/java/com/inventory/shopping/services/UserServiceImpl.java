package com.inventory.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.shopping.model.UserDetails;
import com.inventory.shopping.repositories.UserDetailsRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails userExist(UserDetails loginData) {
		// TODO Auto-generated method stub
		UserDetails userDetails = userDetailsRepo.findByUserName(loginData.getUserName());
		
		log.info("result from db :: "+userDetails);
		return userDetails;
	}

}
