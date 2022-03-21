package com.freetuts.service;

import java.util.List;

import com.freetuts.dto.TagDto;
import com.freetuts.entity.Tag;

public interface TagService {
	// lấy thẻ tag theo category id
		public List<Tag> tagList(int category_Detail_Id, int status);

		public TagDto getTagContent(int tagId);

		// lấy thẻ tag cho admin ko có tham số truyền vào
		public List<TagDto> adminGetTagList();

//		// admin
//		// admin xóa tag bằng cách cập nhật lại status cho tag bằng 0.
//		public void adminDeleteTag(int id);

		public void findTagToChangeStatus(int tagId);
		
		public List<TagDto> getTagIdAndName();

		
}
