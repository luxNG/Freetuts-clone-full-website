package com.freetuts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freetuts.dto.CategoryDetailDto;
import com.freetuts.dto.TagDto;
import com.freetuts.entity.CategoryDetail;
import com.freetuts.entity.Tag;
import com.freetuts.repository.CategoryDetailRepository;
import com.freetuts.repository.TagRepository;
import com.freetuts.service.CategoryDetailService;

@Service
public class CategoryDetailServiceImpl implements CategoryDetailService {

	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private CategoryDetailRepository categoryDetailRepository;

	// lấy danh sách lập trình
	@Override
	public List<CategoryDetailDto> danhSachLapTrinh() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(1, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// lấy danh sach khóa học
	@Override
	public List<CategoryDetailDto> danhSachKhoaHoc() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(2, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// lấy danh sách website
	@Override
	public List<CategoryDetailDto> danhSachWebsite() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(3, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// lấy danh sách mã giảm giá
	@Override
	public List<CategoryDetailDto> danhSachMaGiamGia() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(4, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// lấy danh sách tin học
	@Override
	public List<CategoryDetailDto> danhSachTinHoc() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(5, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// lấy danh sách thủ thuật
	@Override
	public List<CategoryDetailDto> danhSachThuThuat() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(6, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// danh sách download
	@Override
	public List<CategoryDetailDto> danhSachDownLoad() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(7, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// danh sach môn học
	@Override
	public List<CategoryDetailDto> danhSachMonHoc() {
		List<CategoryDetail> list = categoryDetailRepository.findBycategoryIdAndStatus(8, 1);
		List<CategoryDetailDto> listDto = new ArrayList<>();
		for (CategoryDetail categoryDetail : list) {
			listDto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
					categoryDetail.getCategoryDetailName()));
		}
		return listDto;
	}

	// lấy nội dung của categorydetail bằng id
	@Override
	public CategoryDetailDto danhSachNoiDung(int id, int status) {
		CategoryDetail categoryDetail = categoryDetailRepository.findBycategoryDetailIdAndStatus(id, status);
		CategoryDetailDto dto = new CategoryDetailDto(categoryDetail.getCategoryDetailId(), 0,
				categoryDetail.getCategoryDetailName(), "", categoryDetail.getContent());
		return dto;
	}

	@Override
	public List<Tag> tagList(int category_Detail_Id) {
		return tagRepository.findBycategoryDetailIdAndStatus(category_Detail_Id, 1);
	}

	// lấy bài post theo category id
	@Override
	public List<TagDto> getPostByCategoryId(int category_Detail_Id) {
		return tagRepository.getCategoryIdAndPost(category_Detail_Id);
	}

	// lấy admin category detail , detail id, detail name, category id;
	// int categoryDetailId, int categoryId, String categoryDetailName, String
	// categoryName
	@Override
	public List<CategoryDetailDto> adminGetCategoryDetail() {
		List<CategoryDetail> list = categoryDetailRepository.findAll();
		List<CategoryDetailDto> dto = new ArrayList<CategoryDetailDto>();
		for (CategoryDetail categoryDetail : list) {
			if (categoryDetail.getStatus() != 0) {
				dto.add(new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getCategoryId(),
						categoryDetail.getCategoryDetailName(), categoryDetail.getCategory().getCategoryName(), ""));
			}
		}
		return dto;
	}

	// Đổi trạng thái category detail có tham số truyền vào là id
	@Override
	public void adminChangeStatusCategoryDetailById(int categoryDetailId) {
		CategoryDetail categoryDetail = categoryDetailRepository.findById(categoryDetailId).get();
		categoryDetail.setStatus(0);
		categoryDetailRepository.save(categoryDetail);
	}
	
	@Override
	public CategoryDetail findByCategoryDetailIdForUpdate(int id) {
		CategoryDetail categoryDetail = categoryDetailRepository.findById(id).get();
		return categoryDetail;
	}

	@Override
	public void saveAfterUpdate(CategoryDetail categoryDetail) {
		categoryDetailRepository.save(categoryDetail);
	}
}
