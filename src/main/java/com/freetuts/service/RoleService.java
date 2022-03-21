package com.freetuts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freetuts.entity.Role;

@Service
public interface RoleService {
	List<Role> getRoleNames();
}
