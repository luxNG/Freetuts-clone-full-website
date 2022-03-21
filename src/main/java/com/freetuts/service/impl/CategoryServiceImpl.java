package com.freetuts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.freetuts.dto.CategoryDto;
import com.freetuts.entity.Category;
import com.freetuts.repository.CategoryRepository;
import com.freetuts.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> getCategoryList() {
		List<Category> categoryList = categoryRepository.findAll();
		List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
		for (Category category : categoryList) {
			categoryDtoList.add(new CategoryDto(category.getCategoryId(), category.getCategoryName()));
		}
		return categoryDtoList;
	}
	
}
