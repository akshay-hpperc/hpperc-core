package com.hpperc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpperc.model.Role;
import com.hpperc.repository.RoleRepository;

@Service
public class CommonServiceImpl implements ICommonService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

}
