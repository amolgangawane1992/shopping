package com.inventory.shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.shopping.model.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {

	UserDetails findByUserName(String userName);
}
