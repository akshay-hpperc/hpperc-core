package com.hpperc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hpperc.model.User;
import com.hpperc.repository.UserRepository;



@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	 /*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUserName(), 
					user.getPassword(), 
					user.getRoles()
					.stream()
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		}else {
			throw new UsernameNotFoundException("User does not exist");
		}
	}
	*/
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(user);
	}
	@Override
	public List<User> findUsersByRole(int roleId) {
		
		return null;
	}
	
	@Override
	public String randomPasswordGeneration() {
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int count=7;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		

		return builder.toString();
		 
	}
	 
	
}