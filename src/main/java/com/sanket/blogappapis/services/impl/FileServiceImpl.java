package com.sanket.blogappapis.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sanket.blogappapis.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		// File Name
		String fileName = file.getOriginalFilename();

		// Full path
		String fullPath = path + File.separator + fileName;

		// Create folder if not created
		File filePath = new File(path);
		
		if(!filePath.exists())
			filePath.mkdir();

		// File copy
		Files.copy(file.getInputStream(), Paths.get(fullPath));

		return fileName;
	}

}
