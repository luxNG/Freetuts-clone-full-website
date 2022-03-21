package com.freetuts.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private int authorId;
	private int tagId;
	private String title;
	private String createAt;
	private String content;
	private String titleImg;
	private int status;

	// tham chiếu từ tag qua post
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tagId", insertable = false, updatable = false)
	private Tag tag;

	// tham chiếu từ author qua post
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId", insertable = false, updatable = false)
	private Author author;

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int post_Id, int author_Id, int tag_Id, String title, String create_At, String content) {
		super();
		this.postId = post_Id;
		this.authorId = author_Id;
		this.tagId = tag_Id;
		this.title = title;
		this.createAt = create_At;
		this.content = content;
	}

	public Post(int post_Id, int author_Id, int tag_Id, String title, String create_At, String content,
			String title_Img, Tag tag, Author author) {
		super();
		this.postId = post_Id;
		this.authorId = author_Id;
		this.tagId = tag_Id;
		this.title = title;
		this.createAt = create_At;
		this.content = content;
		this.titleImg = title_Img;
		this.tag = tag;
		this.author = author;
	}

	// post_Id, author_Id, content,create_At, tag_Id, title, title_Img, status
	// constructor để tạo mới bài viết
	public Post(int postId, int authorId, int tagId, String title, String createAt, String content, String titleImg,
			int status) {
		super();
		this.postId = postId;
		this.authorId = authorId;
		this.tagId = tagId;
		this.title = title;
		this.createAt = createAt;
		this.content = content;
		this.titleImg = titleImg;
		this.status = status;
	}

}
