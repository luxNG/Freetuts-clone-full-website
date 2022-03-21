package com.freetuts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
	private int categoryId;
	private String categoryName;
	private int status;

	public CategoryDto() {

	}

	public CategoryDto(int category_Id, String category_Name) {
		super();
		this.categoryId = category_Id;
		this.categoryName = category_Name;
	}

}
