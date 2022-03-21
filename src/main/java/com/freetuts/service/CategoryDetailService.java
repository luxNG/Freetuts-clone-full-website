package com.freetuts.service;

import java.util.List;
import com.freetuts.dto.CategoryDetailDto;
import com.freetuts.dto.TagDto;
import com.freetuts.entity.CategoryDetail;
import com.freetuts.entity.Tag;

public interface CategoryDetailService {
	// lấy danh sách lập trình
	public List<CategoryDetailDto> danhSachLapTrinh();

	// lấy danh sách khóa học
	public List<CategoryDetailDto> danhSachKhoaHoc();

	// lấy danh sách website
	public List<CategoryDetailDto> danhSachWebsite();

	// lấy danh sách website
	public List<CategoryDetailDto> danhSachMaGiamGia();

	// lấy danh sách tin học
	public List<CategoryDetailDto> danhSachTinHoc();

	// lấy danh sách thu thuat
	public List<CategoryDetailDto> danhSachThuThuat();

	// lấy danh sách download
	public List<CategoryDetailDto> danhSachDownLoad();

	// lấy danh sách môn học
	public List<CategoryDetailDto> danhSachMonHoc();

	// lấy nội dung content
	public CategoryDetailDto danhSachNoiDung(int id, int status);

	// lấy thẻ tag theo category id
	public List<Tag> tagList(int category_Detail_Id);

	// lấy post theo category id
	public List<TagDto> getPostByCategoryId(int category_Detail_Id);

	// lấy admin category detail
	public List<CategoryDetailDto> adminGetCategoryDetail();

	// admin tìm category detail theo id và thay đổi trạng thái trong db.
	public void adminChangeStatusCategoryDetailById(int categoryDetailId);

	// tìm category detail theo id để update category detail
	public CategoryDetail findByCategoryDetailIdForUpdate(int id);

	// save
	public void saveAfterUpdate(CategoryDetail categoryDetail);

}
