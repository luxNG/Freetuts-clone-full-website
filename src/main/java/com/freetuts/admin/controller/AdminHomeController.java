package com.freetuts.admin.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.freetuts.entity.Post;
import com.freetuts.model.BlogPost;
import com.freetuts.service.AuthorService;
import com.freetuts.service.CategoryDetailService;
import com.freetuts.service.FileUploadService;
import com.freetuts.service.PostService;
import com.freetuts.service.TagService;

@Controller
public class AdminHomeController {

	@Autowired
	private PostService postService;
	@Autowired
	private TagService tagService;
	@Autowired
	private CategoryDetailService categoryDetailService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private FileUploadService fileUploadService;
	

	// cho button post ở side bar
	@GetMapping("/posts")
	public String getAllPost(ModelMap modelMap) {
		modelMap.addAttribute("adminGetAllPost", postService.adminGetAllPost());
		return "posts";
	}

	// cho button tag ở side bar
	@GetMapping("/tags")
	public String getAllTag(ModelMap modelMap) {
		modelMap.addAttribute("adminGetAllTag", tagService.adminGetTagList());
		return "tags";
	}

	// cho button category detail ở side bar
	@GetMapping("/category-details")
	public String getAllCategoryDetail(ModelMap modelMap) {
		modelMap.addAttribute("adminGetAllCategoryDetail", categoryDetailService.adminGetCategoryDetail());
		return "category-details";
	}

	@GetMapping("/admin")
	public Object getAdmin() {
		return "admin";
	}

	@GetMapping("/create-post")
	public String addEditPost(Model model, @RequestParam("blogPostId") Optional<String> blogPostId) {
		setDefaultBlogPost(model);
		model.addAttribute("tagInfor", tagService.getTagIdAndName());
		return "create-post";
	}

	// postId, authorId, tagId, title, createAt, content, titleImg, status
	@PostMapping("/create-post")
	public String addEditPostSubmit(Model model, BlogPost blogPost,
			@RequestParam("fileTitleImage") MultipartFile fileTitleImage,
			@RequestParam("tagSelected") int tagSelected) {
		
		//lấy ngày hiện tại để lưu vào bảng post
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String today = df.format(new Date());
		
		// lấy user name và id của tài khoản đang đăng nhập
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		int id = authorService.findByAuthorName(username).getAuthorId();
		/*
		 * System.out.println("=======================" + id);
		 * System.out.println("=======================" + username);
		 */
		
		// upload ảnh tile_image của Post
		fileUploadService.uploadToLocal(fileTitleImage);
		String fileName = fileUploadService.uploadToLocal(fileTitleImage);
		
		  Post post = new Post(0, id, tagSelected, blogPost.getTitle(), today,
		  blogPost.getBody(), "/images/" + fileName, 1);
		 
//		System.out.println(tagSelected);
//		System.out.println("Title is " + blogPost.getTitle());
//		System.out.println("Body is " + blogPost.getBody());
		postService.makeNewPost(post);
		return "redirect:/create-post";
	}

	private void setDefaultBlogPost(Model model) {
		BlogPost blogPost = new BlogPost();
		model.addAttribute("blogPost", blogPost);
	}

	@GetMapping("/user")
	public Object getUser() {
		return "user";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

}
