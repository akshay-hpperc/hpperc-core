package com.hpperc.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.hpperc.model.User;

public interface IUserService {
	User findByUserName(String userName);
	User saveUser(User user);
	UserDetails loadUserByUsername(String username); 
	List<User> findUsersByRole(int roleId);
	String randomPasswordGeneration();
	
}