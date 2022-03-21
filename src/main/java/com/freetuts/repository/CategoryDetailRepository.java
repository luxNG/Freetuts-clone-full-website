package com.freetuts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.freetuts.entity.CategoryDetail;

public interface CategoryDetailRepository extends JpaRepository<CategoryDetail, Integer> {


//	 lấy danh sách khóa học
//	@Query("Select new com.freetuts.dto.CategoryDetailDto(cd.categoryDetailId,  c.categoryId, cd.categoryDetailName) From CategoryDetail cd JOIN Category c ON cd.categoryId = c.categoryId where c.categoryId = 2")
//	public List<CategoryDetailDto> getKhoaHoc();

	// lấy danh sách java khóa học lập trình kiến thức domain...
		public List<CategoryDetail> findBycategoryIdAndStatus(@Param("id") int id, @Param("status") int status);

//	@Query("Select new com.freetuts.entity.CategoryDetail(cd.categoryDetailId,  cd.categoryDetailName, cd.content) From CategoryDetail cd  where cd.categoryDetailId = :id")
//	public CategoryDetail getContentCategoryDetail(@Param("id") int id);
	
	// lấy thông tin của category detail (id, name, content) entity bằng id
		public CategoryDetail findBycategoryDetailIdAndStatus(@Param("id") int id, @Param("status") int status);

}
