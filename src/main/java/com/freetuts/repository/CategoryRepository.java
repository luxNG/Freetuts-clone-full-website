package com.freetuts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freetuts.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Category findBycategoryIdAndStatus(@Param("id") int id, @Param("Status") int status);
}
