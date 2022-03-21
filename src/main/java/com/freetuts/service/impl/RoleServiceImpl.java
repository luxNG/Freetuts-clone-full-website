package com.freetuts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.freetuts.entity.Role;
import com.freetuts.repository.RoleRepository;
import com.freetuts.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;
	@Override
	public List<Role> getRoleNames() {
		return roleRepository.findAll();
	}

}
