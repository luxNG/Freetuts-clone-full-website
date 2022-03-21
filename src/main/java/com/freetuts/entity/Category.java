package com.freetuts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	private String categoryName;
	
	private int status;

	@OneToMany(mappedBy = "categoryId", fetch = FetchType.LAZY)
	List<CategoryDetail> categoryDetail;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int category_Id, String category_Name) {
		super();
		this.categoryId = category_Id;
		this.categoryName = category_Name;
	}

}
