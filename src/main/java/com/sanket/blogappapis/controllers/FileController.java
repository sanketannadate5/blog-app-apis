package com.sanket.blogappapis.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sanket.blogappapis.payloads.ImageResponse;
import com.sanket.blogappapis.services.FileService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/upload")
	public ResponseEntity<ImageResponse> fileUpload(
			@RequestParam ("image") MultipartFile image
			){
		String fileName = null;
		try {
			fileName = fileService.uploadImage(path, image);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<ImageResponse>(new ImageResponse(fileName, "Image is uploaded Failed due to server error !!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ImageResponse>(new ImageResponse(fileName, "Image is uploaded successfully !!"),HttpStatus.OK );
	}

	// method to serve file
	@GetMapping(value = "image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName, HttpServletResponse httpServletResponse) throws IOException {

		InputStream inputStream = fileService.getResource(path, imageName);
		
		httpServletResponse.setContentType(MediaType.IMAGE_JPEG_VALUE);
		
		StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());

	}
}
