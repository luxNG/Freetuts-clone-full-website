package com.freetuts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDetailDto {
	private int categoryDetailId;
	private int categoryId;
	private String categoryDetailName;
	private String categoryName;
	private String content;
	private int status;

	public CategoryDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDetailDto(int category_Detail_Id, int category_Id, String category_Detail_Name) {
		super();
		this.categoryDetailId = category_Detail_Id;
		this.categoryId = category_Id;
		this.categoryDetailName = category_Detail_Name;
	}

	public CategoryDetailDto(int category_Detail_Id, String category_Detail_Name, String category_Name) {
		super();
		this.categoryDetailId = category_Detail_Id;
		this.categoryDetailName = category_Detail_Name;
		this.categoryName = category_Name;
	}

	public CategoryDetailDto(int categoryDetailId, int categoryId, String categoryDetailName, String categoryName,
			String content) {
		super();
		this.categoryDetailId = categoryDetailId;
		this.categoryId = categoryId;
		this.categoryDetailName = categoryDetailName;
		this.categoryName = categoryName;
		this.content = content;
	}

}
