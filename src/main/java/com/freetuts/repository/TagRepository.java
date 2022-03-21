package com.freetuts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.freetuts.dto.TagDto;
import com.freetuts.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
	@Query("Select new com.freetuts.dto.TagDto( cd.categoryDetailId, p.postId, p.title, p.titleImg) from CategoryDetail cd JOIN Tag t ON cd.categoryDetailId = t.categoryDetailId JOIN Post p ON p.tagId = t.tagId where cd.categoryDetailId = :id")
	public List<TagDto> getCategoryIdAndPost(@Param("id") int category_Detail_Id);

	// t.tag_name, cd.category_detail_id, t.tag_id, t.image_url
	public List<Tag> findBycategoryDetailIdAndStatus(@Param("id") int category_Detail_Id, @Param("status") int id);
	
	// lấy thông tin của tag gồm tag id, tag name
	public List<Tag> findByStatus(@Param("status") int status);
}