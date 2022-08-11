package com.sanket.blogappapis.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sanket.blogappapis.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		// File Name
		String fileName = file.getOriginalFilename();

		String randomID = UUID.randomUUID().toString();

		String[] chunks = fileName.split("\\.");

		String newFileName = chunks[0] + " " + randomID + "." + chunks[1];

		// Full path
		String filePath = path + File.separator + newFileName;

		// Create folder if not created
		File f = new File(path);

		if (!f.exists())
			f.mkdir();

		// File copy
		Files.copy(file.getInputStream(), Paths.get(filePath));

		return newFileName;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		// db logic to return input stram
		return new FileInputStream(path + File.separator + fileName);
	}
}
