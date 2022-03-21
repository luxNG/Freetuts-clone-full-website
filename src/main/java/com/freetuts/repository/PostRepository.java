package com.freetuts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freetuts.dto.PostDto;
import com.freetuts.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
		// lấy thông tin lập trình có category detail id = 1 các bài post chỉ có tên và
		// ảnh;
		@Query("Select new com.freetuts.dto.PostDto(p.postId, p.title, p.titleImg ) from  Post p JOIN Tag t ON p.tagId = t.tagId JOIN CategoryDetail cd ON t.categoryDetailId = cd.categoryDetailId JOIN Category c ON c.categoryId = cd.categoryId WHERE c.categoryId = :id and p.status = :status")
		public List<PostDto> get_Post_Title(@Param("id") int id, @Param("status") int status);


		// lấy thông tin của 1 bài post cụ thể có tham số là post id truyền vào
		@Query("Select new com.freetuts.dto.PostDto(p.postId, a.authorId, t.tagId, p.title, p.createAt, p.content, t.tagName,  a.authorName) from Author a join Post p ON a.authorId = p.authorId  join Tag t ON p.tagId = t.tagId where p.postId = :id and p.status = :status")
		public PostDto getPostDto(@Param("id") int id, @Param("status") int status);

		// lấy post từ tag id
		@Query("Select new com.freetuts.dto.PostDto(p.postId, a.authorId, t.tagId, p.title, p.createAt, p.content, t.tagName,  a.authorName) from Author a join Post p ON a.authorId = p.authorId  join Tag t ON p.tagId = t.tagId where t.tagId = :id and t.status = :status")
		public List<PostDto> getPostFromTagId(@Param("id") int id, @Param("status") int status);

		// admin post controller
		// postid, author, title, tagid, created dates
		@Query("Select new com.freetuts.dto.PostDto(p.postId, a.authorId, t.tagId, p.title, p.createAt, p.content, t.tagName, a.authorName) from Author a join Post p ON a.authorId = p.authorId  join Tag t ON p.tagId = t.tagId and p.status = 1")
		public List<PostDto> adminGetAllPost();
		
		// xóa post theo tagid
		public List<Post> findPostBytagIdAndStatus(@Param("tagId") int id, @Param("status") int status);
}
