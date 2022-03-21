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

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tagId;
	private int categoryDetailId;
	private String tagName;
	private String imageUrl;
	private String tagContent;
	private int status;

	// tham chiếu post qua giá trị list này
	@OneToMany(mappedBy = "tagId", fetch = FetchType.LAZY)
	List<Post> post;

	// tham chiếu category thông qua giá trị này
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryDetailId", insertable = false, updatable = false)
	private CategoryDetail categoryDetail;

	public Tag() {

	}

//cho dto
	public Tag(int tag_Id, int category_Detail_Id, String tag_Name) {
		super();
		this.tagId = tag_Id;
		this.categoryDetailId = category_Detail_Id;
		this.tagName = tag_Name;
	}

	public Tag(int tag_Id, String tag_Name, String image_Url) {
		super();
		this.tagId = tag_Id;
		this.tagName = tag_Name;
		this.imageUrl = image_Url;

	}

	// cho repository tag
	public Tag(int tag_Id, int category_Detail_Id, String tag_Name, String image_Url) {
		super();
		this.tagId = tag_Id;
		this.categoryDetailId = category_Detail_Id;
		this.tagName = tag_Name;
		this.imageUrl = image_Url;
	}
	
	public Tag(int tagId, int categoryDetailId, String tagName, String imageUrl, String tagContent, int status) {
		super();
		this.tagId = tagId;
		this.categoryDetailId = categoryDetailId;
		this.tagName = tagName;
		this.imageUrl = imageUrl;
		this.tagContent = tagContent;
		this.status = status;
	}


}