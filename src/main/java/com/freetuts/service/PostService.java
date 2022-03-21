package com.freetuts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freetuts.dto.PostDto;
import com.freetuts.entity.Post;

@Service
public interface PostService {
	// free blog website
		public List<PostDto> get_Title_Free_Website();

		// manage website
		public List<PostDto> get_Title_Manage_Website();

		// thủ thuật
		public List<PostDto> get_Title_Tip();

		// download
		public List<PostDto> get_Title_Download();

		// tin học
		public List<PostDto> get_Title_informatics();

		// Marketing
		public List<PostDto> get_Title_Marketing();

		// Môn học
		public List<PostDto> get_Title_Subject();

		// get post by id
		public PostDto getPostListById(int id, int status);

		public List<PostDto> get_Title_Program();

		// get post from tag id
		public List<PostDto> getPostFromTagId(int id, int status);

		// admin
		// get all post for admin
		public List<PostDto> adminGetAllPost();
		
		public void adminChangeStatusPostById(int postId);
		
		public void adminChangePostStatusByTagId(int tagId, int status);
		
		public void makeNewPost(Post post);

}
