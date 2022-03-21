package com.freetuts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freetuts.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	Author findByAuthorName(String authorName);
}
