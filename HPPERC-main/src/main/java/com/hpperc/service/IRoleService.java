package com.hpperc.service;

import java.util.List;
import java.util.Optional;

import com.hpperc.model.Role;

public interface IRoleService {

	Optional<Role> findByRoleId(Long roleId);
	Role findByRoleName(String roleName);
}
