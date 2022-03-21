package com.freetuts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freetuts.entity.Author;
import com.freetuts.entity.Role;
import com.freetuts.repository.AuthorRepository;
import com.freetuts.repository.RoleRepository;

@Service
public class AuthorDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		Author author = authorRepository.findByAuthorName(username);
		if (author == null)
			throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
		for (Role roleName: roleRepository.findAll()) {
			if (roleName.getRoleId() == author.getRoleId()) {
				grantedAuthority.add(new SimpleGrantedAuthority(roleName.getRoleName()));
			}
		}
		
		return new org.springframework.security.core.userdetails.User(author.getAuthorName(), 
				author.getPassword(), grantedAuthority);
	}

}
