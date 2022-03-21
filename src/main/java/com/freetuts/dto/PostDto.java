package com.freetuts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

	private int postId;
	private int authorId;
	private int tagId;
	private String title;
	private String createAt;
	private String content;
	private String tagName;
	private String tagContent;
	private String authorName;
	private String titleImg;
	private int status;

	// post dto
		public PostDto() {

		}

		public PostDto(int post_Id, int author_Id, int tag_Id, String title, String create_At, String content) {
			super();
			this.postId = post_Id;
			this.authorId = author_Id;
			this.tagId = tag_Id;
			this.title = title;
			this.createAt = create_At;
			this.content = content;
		}

		public PostDto(int post_Id, String title, String title_Img) {
			super();
			this.postId = post_Id;
			this.title = title;
			this.titleImg = title_Img;
		}

	//post repository query

		public PostDto(int post_Id, int author_Id, int tag_Id, String title, String create_At, String content,
				String tag_Name, String author_Name) {
			super();
			this.postId = post_Id;
			this.authorId = author_Id;
			this.tagId = tag_Id;
			this.title = title;
			this.createAt = create_At;
			this.content = content;
			this.tagName = tag_Name;
			this.authorName = author_Name;
		}

		public PostDto(int postId, int authorId, int tagId, String title, String createAt, String content, String tagName,
				String tagContent, String authorName, String titleImg) {
			super();
			this.postId = postId;
			this.authorId = authorId;
			this.tagId = tagId;
			this.title = title;
			this.createAt = createAt;
			this.content = content;
			this.tagName = tagName;
			this.tagContent = tagContent;
			this.authorName = authorName;
			this.titleImg = titleImg;
		}

}
