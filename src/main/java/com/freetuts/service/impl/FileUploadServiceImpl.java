package com.freetuts.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.freetuts.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	private String uploadDirectory = "./src/main/resources/static/images/";

	@Override
	public String uploadToLocal(MultipartFile fileUpload) {
		String fileName = "";
		try {	
			fileName = fileUpload.getOriginalFilename();
			System.out.println("File upload là : " + fileUpload.getName());
			System.out.println("File Name là : " + fileName);
			byte[] data = fileUpload.getBytes();
			Path path = Paths.get(uploadDirectory + fileName);
			System.out.println("Path của file là : " + path);
			Files.write(path, data);

		} catch (Exception e) {
			System.out.println("============ Erorr at uploadToLocal ========" + e.getMessage());
		}
		return fileName;
	}
}
