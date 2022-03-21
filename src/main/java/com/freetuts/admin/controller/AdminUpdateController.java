package com.freetuts.admin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freetuts.entity.CategoryDetail;
import com.freetuts.entity.Post;
import com.freetuts.entity.Tag;
import com.freetuts.model.BlogPost;
import com.freetuts.repository.CategoryDetailRepository;
import com.freetuts.repository.PostRepository;
import com.freetuts.repository.TagRepository;
import com.freetuts.service.CategoryDetailService;

@Controller
@RequestMapping("/admin/update")
public class AdminUpdateController {
	@Autowired
	private CategoryDetailService categoryDetailService;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private TagRepository tagRepository;

//category detail 
	@GetMapping("/categoryDetail/{id}")
	public String getCategoryDetailById(@PathVariable int id, Model model) {
		CategoryDetail categoryDetail = categoryDetailService.findByCategoryDetailIdForUpdate(id);
		model.addAttribute("categoryDetailInfor", categoryDetail);
		return "category-update";
	}

	@PostMapping("/postCategoryDetail")
	public String updateCategoryDetailName(@RequestParam("id") int id, @RequestParam("name") String name) {
		CategoryDetail cate = categoryDetailService.findByCategoryDetailIdForUpdate(id);
		cate.setCategoryDetailName(name);
		categoryDetailService.saveAfterUpdate(cate);
		return "redirect:/category-details";
	}

// tag

	@GetMapping("/tag/{id}")
	public String getTagById(@PathVariable int id, Model model) {
		Tag tag = tagRepository.findById(id).get();
		model.addAttribute("tagDetailInfor", tag);
		return "tag-update";
	}

	@PostMapping("/tag")
	public String updateTag(@RequestParam("id") int id, @RequestParam("name") String name) {
		Tag tag = tagRepository.findById(id).get();
		tag.setTagName(name);
		tagRepository.save(tag);
		return "redirect:/tags";
	}

//post
	@GetMapping("/post/{id}")
	public String getPostById(@PathVariable int id, Model model,
			@RequestParam("blogPostId") Optional<String> blogPostId) {
		setDefaultBlogPost(model);
		Post post = postRepository.findById(id).get();
		model.addAttribute("postDetailInfor", post);
		return "update-post";
	}

	@PostMapping("/update-post")
	public String updatePost(@RequestParam("id") int id, @RequestParam("title") String title,
			@RequestParam("content") String content) {
		Post post = postRepository.findById(id).get();
		System.out.println("===============================" + title);
		post.setTitle(title);
		post.setContent(content);
		postRepository.save(post);
		return "redirect:/posts";
	}

	private void setDefaultBlogPost(Model model) {
		BlogPost blogPost = new BlogPost();
		model.addAttribute("blogPost", blogPost);
	}

}
