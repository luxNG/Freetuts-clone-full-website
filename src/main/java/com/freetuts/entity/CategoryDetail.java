package com.freetuts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "categorydetail")
@Entity
@Getter
@Setter
public class CategoryDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryDetailId;
	private int categoryId;
	private String categoryDetailName;
	private String content;
	private int status;

	@OneToMany(mappedBy = "categoryDetailId", fetch = FetchType.LAZY)
	List<Tag> tag;

	@ManyToOne(fetch = FetchType.LAZY)
	// tham chiếu thông qua giá trị này
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	private Category category;

	public CategoryDetail() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDetail(int category_Detail_Id, String category_Detail_Name, String content) {
		super();
		this.categoryDetailId = category_Detail_Id;
		this.categoryDetailName = category_Detail_Name;
		this.content = content;
	}

	public CategoryDetail(int category_Detail_Id, int category_Id, String category_Detail_Name) {
		super();
		this.categoryDetailId = category_Detail_Id;
		this.categoryId = category_Id;
		this.categoryDetailName = category_Detail_Name;
	}

}
