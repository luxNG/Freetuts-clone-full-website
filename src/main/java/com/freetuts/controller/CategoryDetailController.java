package com.freetuts.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.freetuts.service.CategoryDetailService;
import com.freetuts.service.TagService;


@Controller
public class CategoryDetailController {
	@Autowired
	private CategoryDetailService categoryDetailService;
	@Autowired
	private TagService tagService;

	@GetMapping("/detail/{id}")
	public ModelAndView getContent(@PathVariable("id") int categoryDetailId) {
		Map<String, Object> params = new HashMap<>();
		try {
			params.put("DetailContentPage", categoryDetailService.danhSachNoiDung(categoryDetailId, 1));
			params.put("ProgramList", categoryDetailService.danhSachLapTrinh());
			params.put("KhoaHocList", categoryDetailService.danhSachKhoaHoc());
			params.put("WebsiteList", categoryDetailService.danhSachWebsite());
			params.put("MaGiamGiaList", categoryDetailService.danhSachMaGiamGia());
			params.put("TinHocList", categoryDetailService.danhSachTinHoc());
			params.put("ThuThuatList", categoryDetailService.danhSachThuThuat());
			params.put("DownloadList", categoryDetailService.danhSachDownLoad());
			params.put("MonHocList", categoryDetailService.danhSachMonHoc());
			params.put("TagList", tagService.tagList(categoryDetailId, 1));
			params.put("GetPostByCategoryDetailID", categoryDetailService.getPostByCategoryId(categoryDetailId));
		} catch (Exception e) {
			System.out.println("===== ERROR CATEGORY DETAIL ===== " + e.getMessage());
		}
		return new ModelAndView("category-content", params);
	}

}
