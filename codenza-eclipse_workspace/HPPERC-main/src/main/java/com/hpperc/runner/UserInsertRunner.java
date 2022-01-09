package com.hpperc.runner;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hpperc.enums.UserRole;
import com.hpperc.model.User;
import com.hpperc.repository.UserRepository;

 

@Component
public class UserInsertRunner implements CommandLineRunner {

	private static final Logger LOGGER = Logger.getLogger(UserInsertRunner.class.getName());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {

		/*
		String password = "password";
		
		Set<String> rolesFirst = new HashSet<>();
		rolesFirst.add("ROLE_"+UserRole.MASTER_ADMIN.getType());
		User newUserFirst = new User("admin",passwordEncoder.encode(password),rolesFirst, LocalDateTime.now(),"","","");
		 
		Set<String> rolesSecond = new HashSet<>();
		rolesSecond.add("ROLE_"+UserRole.HP_ADMIN.getType());
		User newUserSecond = new User("parish",passwordEncoder.encode(password),rolesSecond, LocalDateTime.now(),"","","");
		
		Set<String> rolesThird = new HashSet<>();
		rolesThird.add("ROLE_"+UserRole.HP_USER.getType());
		User newUseThird = new User("yogesh_pagar",passwordEncoder.encode(password),rolesThird, LocalDateTime.now(),"yogesh","uttam","pagar");
		 
		Set<String> rolesFour = new HashSet<>();
		rolesFour.add("ROLE_"+UserRole.UNIVERSITY_ADMIN.getType());
		User newUseFour = new User("akshay",passwordEncoder.encode(password),rolesFour, LocalDateTime.now(),"","","");
		
		Set<String> rolesFive = new HashSet<>();
		rolesFive.add("ROLE_"+UserRole.UNIVERSITY_USER.getType());
		User newUseFive = new User("kunal",passwordEncoder.encode(password),rolesFive, LocalDateTime.now(),"","","");
		
		
		userRepository.save(newUserFirst);
		userRepository.save(newUserSecond);
		userRepository.save(newUseThird);
		userRepository.save(newUseFour);
		userRepository.save(newUseFive);
		 */
		LOGGER.info("Users have been inserted");
	}

}