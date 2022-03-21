package com.freetuts.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.freetuts.service.CategoryDetailService;
import com.freetuts.service.PostService;
import com.freetuts.service.TagService;

@Controller
public class AdminDeleteController {
	@Autowired
	private PostService postService;
	@Autowired
	private TagService tagService;
	@Autowired
	private CategoryDetailService categoryDetailService;

	@GetMapping("/deleteTag/{id}")
	public String adminDeleteTagByTagId(@PathVariable int id) {
		tagService.findTagToChangeStatus(id);
		postService.adminChangePostStatusByTagId(id, 1);
		return "redirect:/tags";
	}

	@GetMapping("/deletePost/{id}")
	public String adminDeletePostByPostId(@PathVariable int id) {
		postService.adminChangeStatusPostById(id);
		return "redirect:/posts";
	}

	@GetMapping("/deleteCategoryDetail/{id}")
	public String adminDeleteCategoryDetailById(@PathVariable int id) {
		categoryDetailService.adminChangeStatusCategoryDetailById(id);
		return "redirect:/category-details";
	}
}
