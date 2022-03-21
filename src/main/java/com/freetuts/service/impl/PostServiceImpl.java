package com.freetuts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freetuts.dto.PostDto;
import com.freetuts.entity.Post;
import com.freetuts.repository.PostRepository;
import com.freetuts.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	// lấy tên lập trình
	@Override
	public List<PostDto> get_Title_Program() {
		return postRepository.get_Post_Title(1, 1);
	}

	// manage website
	@Override
	public List<PostDto> get_Title_Manage_Website() {
		return postRepository.get_Post_Title(3, 1);
	}

	// tin học
	@Override
	public List<PostDto> get_Title_informatics() {
		return postRepository.get_Post_Title(5, 1);
	}

	// thủ thuật
	@Override
	public List<PostDto> get_Title_Tip() {
		return postRepository.get_Post_Title(6, 1);
	}

	// download
	@Override
	public List<PostDto> get_Title_Download() {
		return postRepository.get_Post_Title(7, 1);
	}

	// Môn học
	@Override
	public List<PostDto> get_Title_Subject() {
		return postRepository.get_Post_Title(8, 1);
	}

	// free blog website
	@Override
	public List<PostDto> get_Title_Free_Website() {
		return postRepository.get_Post_Title(9, 1);
	}

	// Marketing
	@Override
	public List<PostDto> get_Title_Marketing() {
		return postRepository.get_Post_Title(10, 1);
	}

	// lấy 1 bài post từ database
	@Override
	public PostDto getPostListById(int id, int status) {
		PostDto postDto = postRepository.getPostDto(id, status);
		return postDto;

	}

	// lấy post từ tag id
	// int postId, int authorId, int tagId, String title, String createAt, String
	// content, String tagName,
	// String tagContent, String authorName, String titleImg
	@Override
	public List<PostDto> getPostFromTagId(int id, int status) {
		return postRepository.getPostFromTagId(id, status);
	}

	// admin
	// get all post information
	@Override
	public List<PostDto> adminGetAllPost() {
		return postRepository.adminGetAllPost();
	}

	@Override
	public void adminChangeStatusPostById(int postId) {
		Post post = postRepository.findById(postId).get();
		post.setStatus(0);
		postRepository.save(post);
	}

	@Override
	public void adminChangePostStatusByTagId(int tagId, int status) {
		List<Post> list = postRepository.findPostBytagIdAndStatus(tagId, status);
		for (Post postList : list) {
			postList.setStatus(0);
			postRepository.save(postList);
		}
	}

	// admin tạo mới bài viết
	@Override
	public void makeNewPost(Post post) {
		postRepository.save(post);

	}

}
