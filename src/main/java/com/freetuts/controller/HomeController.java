package com.freetuts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.freetuts.dto.CategoryDetailDto;
import com.freetuts.dto.PostDto;
import com.freetuts.dto.TagDto;
import com.freetuts.service.CategoryDetailService;
import com.freetuts.service.PostService;
import com.freetuts.service.TagService;

@Controller
public class HomeController {
	@Autowired
	private CategoryDetailService categoryDetailService;
	@Autowired
	private PostService postService;

	@Autowired
	private TagService tagService;

	// trang home của freetuts
	@GetMapping("")
	public ModelAndView homePage() {
		Map<String, Object> params = new HashMap<>();
		params.put("Program", postService.get_Title_Program());
		params.put("FreeWebsite", postService.get_Title_Free_Website());
		params.put("ManageWebsite", postService.get_Title_Manage_Website());
		params.put("TinHoc", postService.get_Title_informatics());
		params.put("Tips", postService.get_Title_Tip());
		params.put("Download", postService.get_Title_Download());
		params.put("Marketing", postService.get_Title_Marketing());
		params.put("Subject", postService.get_Title_Subject());

		params.put("ProgramList", categoryDetailService.danhSachLapTrinh());
		params.put("KhoaHocList", categoryDetailService.danhSachKhoaHoc());
		params.put("WebsiteList", categoryDetailService.danhSachWebsite());
		params.put("MaGiamGiaList", categoryDetailService.danhSachMaGiamGia());
		params.put("TinHocList", categoryDetailService.danhSachTinHoc());
		params.put("ThuThuatList", categoryDetailService.danhSachThuThuat());
		params.put("DownloadList", categoryDetailService.danhSachDownLoad());
		params.put("MonHocList", categoryDetailService.danhSachMonHoc());
		return new ModelAndView("index", params);
	}

	// lấy 1 bài post cụ thể
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, ModelMap map) {
		PostDto postDto = postService.getPostListById(id, 1);
		map.addAttribute("PostPost", postDto);
		map.put("ProgramList", categoryDetailService.danhSachLapTrinh());
		map.put("KhoaHocList", categoryDetailService.danhSachKhoaHoc());
		map.put("WebsiteList", categoryDetailService.danhSachWebsite());
		map.put("MaGiamGiaList", categoryDetailService.danhSachMaGiamGia());
		map.put("TinHocList", categoryDetailService.danhSachTinHoc());
		map.put("ThuThuatList", categoryDetailService.danhSachThuThuat());
		map.put("DownloadList", categoryDetailService.danhSachDownLoad());
		map.put("MonHocList", categoryDetailService.danhSachMonHoc());
		return "post";
	}

	@GetMapping("/post/tag/{id}")
	public String getPostByTagId(@PathVariable int id, ModelMap map) {
		List<PostDto> list = postService.getPostFromTagId(id, 1);
		TagDto tagContentDto = tagService.getTagContent(id);
		map.addAttribute("TagContent", tagContentDto);
		map.addAttribute("PostByTagId", list);
		map.put("ProgramList", categoryDetailService.danhSachLapTrinh());
		map.put("KhoaHocList", categoryDetailService.danhSachKhoaHoc());
		map.put("WebsiteList", categoryDetailService.danhSachWebsite());
		map.put("MaGiamGiaList", categoryDetailService.danhSachMaGiamGia());
		map.put("TinHocList", categoryDetailService.danhSachTinHoc());
		map.put("ThuThuatList", categoryDetailService.danhSachThuThuat());
		map.put("DownloadList", categoryDetailService.danhSachDownLoad());
		map.put("MonHocList", categoryDetailService.danhSachMonHoc());
		return "post-by-tag";
	}

}
