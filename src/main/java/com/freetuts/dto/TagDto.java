package com.freetuts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDto {
	private int tagId;
	private int categoryDetailId;
	private int postId;
	private String tagName;
	private String tagImageUrl;
	private String categoryDetailName;
	private String postTitle;
	private String postImageUrl;
	private String tagContent;
	private int status;

	public TagDto() {

	}

	public TagDto(int tag_Id, int category_Detail_Id, String tag_Name) {
		super();
		this.tagId = tag_Id;
		this.categoryDetailId = category_Detail_Id;
		this.tagName = tag_Name;

	}

	public TagDto(int category_Detail_Id, int post_Id, String post_Title, String post_Image_Url) {
		super();
		this.categoryDetailId = category_Detail_Id;
		this.postId = post_Id;
		this.postTitle = post_Title;
		this.postImageUrl = post_Image_Url;
	}

	public TagDto(int tagId, int categoryDetailId, int postId, String tagName, String tagImageUrl,
			String categoryDetailName, String postTitle, String postImageUrl) {
		super();
		this.tagId = tagId;
		this.categoryDetailId = categoryDetailId;
		this.postId = postId;
		this.tagName = tagName;
		this.tagImageUrl = tagImageUrl;
		this.categoryDetailName = categoryDetailName;
		this.postTitle = postTitle;
		this.postImageUrl = postImageUrl;
	}

	public TagDto(int tagId, int categoryDetailId, int postId, String tagName, String tagImageUrl, String tagContent,
			String categoryDetailName, String postTitle, String postImageUrl) {
		super();
		this.tagId = tagId;
		this.categoryDetailId = categoryDetailId;
		this.postId = postId;
		this.tagName = tagName;
		this.tagImageUrl = tagImageUrl;
		this.tagContent = tagContent;
		this.categoryDetailName = categoryDetailName;
		this.postTitle = postTitle;
		this.postImageUrl = postImageUrl;
	}
}