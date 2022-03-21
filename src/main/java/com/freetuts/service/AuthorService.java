package com.freetuts.service;

import com.freetuts.entity.Author;

public interface AuthorService {
	void save(Author author);
	
	Author findByAuthorName(String authorName);
}
