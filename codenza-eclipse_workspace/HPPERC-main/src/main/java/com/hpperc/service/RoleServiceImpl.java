package com.hpperc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpperc.model.Role;
import com.hpperc.repository.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Optional<Role> findByRoleId(Long roleId) {
		 return roleRepository.findById(roleId);
	}

	@Override
	public Role findByRoleName(String roleName) {
		 
		 return roleRepository.findByName(roleName).get(0);
	}

}
