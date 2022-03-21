package com.freetuts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.freetuts.entity.Author;
import com.freetuts.repository.AuthorRepository;
import com.freetuts.repository.RoleRepository;
import com.freetuts.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	RoleRepository RoleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(Author author) {
		author.setPassword(bCryptPasswordEncoder.encode(author.getPassword()));
		authorRepository.save(author);
	}

	@Override
	public Author findByAuthorName(String authorName) {
		return authorRepository.findByAuthorName(authorName);
	}

}
