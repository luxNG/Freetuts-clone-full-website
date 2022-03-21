package com.freetuts.entity;

import java.util.List;

import javax.persistence.Column;
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
@Table(name = "author")
@Getter
@Setter
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	
	@Column(nullable = false, unique = true)
	private String authorName;
	private String password;
	private int roleId;
	
	@OneToMany(mappedBy = "authorId", fetch = FetchType.LAZY)
	List<Post> post;
	
	//tham chieu tu role qua author
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", insertable = false, updatable = false)
	private Role role;
	
	public Author() {

	}

	public Author(int author_Id, String author_Name, String password, int role_id) {
		super();
		this.authorId = author_Id;
		this.authorName = author_Name;
		this.password = password;
		this.roleId = role_id;
	}

}
