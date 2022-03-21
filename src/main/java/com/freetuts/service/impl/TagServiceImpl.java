package com.freetuts.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freetuts.dto.TagDto;
import com.freetuts.entity.Tag;
import com.freetuts.repository.TagRepository;
import com.freetuts.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagRepository tagRepository;

	// int tag_Id, int category_Detail_Id, String tag_Name, String image_Url
	@Override
	public List<Tag> tagList(int category_Detail_Id, int status) {
		return tagRepository.findBycategoryDetailIdAndStatus(category_Detail_Id, status);
	}

	// lấy tag content cho trang post by tag
	@Override
	public TagDto getTagContent(int tagId) {
		Tag tag = tagRepository.findById(tagId).get();
		TagDto dto = new TagDto();
		dto.setTagContent(tag.getTagContent());
		return dto;
	}

	// int tag_Id, int category_Detail_Id, String tag_Name, category detail id,
	// category detail name
	@Override
	public List<TagDto> adminGetTagList() {
		List<Tag> list = tagRepository.findAll();
		List<TagDto> dto = new ArrayList<>();
		for (Tag tag : list) {
			if (tag.getStatus() != 0) {
				dto.add(new TagDto(tag.getTagId(), tag.getCategoryDetailId(), 0, tag.getTagName(), "",
						tag.getCategoryDetail().getCategoryDetailName(), "", ""));
			}

		}
		return dto;
	}

	@Override
	public void findTagToChangeStatus(int tagId) {
		Tag tag = tagRepository.findById(tagId).get();
		tag.setStatus(0);
		tagRepository.save(tag);
	}

	// lấy toàn bộ thông tin của tag
	@Override
	public List<TagDto> getTagIdAndName() {
		List<Tag> list = tagRepository.findByStatus(1);
		List<TagDto> dtos = new ArrayList<TagDto>();
		for (Tag tag : list) {
			dtos.add(new TagDto(tag.getTagId(), 0 , tag.getTagName()));
		}
		return dtos;
	}

}
