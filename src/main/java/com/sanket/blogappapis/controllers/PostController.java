package com.sanket.blogappapis.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sanket.blogappapis.commonUtils.CommonConstansts;
import com.sanket.blogappapis.payloads.ApiResponse;
import com.sanket.blogappapis.payloads.PostDto;
import com.sanket.blogappapis.payloads.PostResponse;
import com.sanket.blogappapis.services.FileService;
import com.sanket.blogappapis.services.PostService;

@RestController
@RequestMapping("api/post")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/create/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Long userId,
			@PathVariable Long categoryId) {
		return new ResponseEntity<PostDto>(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
	}

	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,
			@PathVariable("postId") Long postId) {
		return new ResponseEntity<PostDto>(postService.updatePost(postDto, postId), HttpStatus.CREATED);
	}

	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponse> deletePostById(@PathVariable("postId") Long postId) {
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted Successfully !!", true), HttpStatus.OK);
	}

	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable("postId") Long postId) {
		PostDto postDto = postService.getSinglePost(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.ACCEPTED);
	}

	@GetMapping("/")
	public ResponseEntity<PostResponse> getAllpost(
			@RequestParam(value = "pageNumber", defaultValue = CommonConstansts.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = CommonConstansts.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = CommonConstansts.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDirection", defaultValue = CommonConstansts.SORT_DIRECTION, required = false) String sortDirection) {
		PostResponse postResponse = postService.getAllPost(pageNumber, pageSize, sortBy, sortDirection);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{userId}/user")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId) {
		List<PostDto> postDtos = postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}

	@GetMapping("/{categoryId}/category")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId) {
		List<PostDto> postDtos = postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}

	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable("keyword") String keyword) {
		List<PostDto> postDtos = postService.searchPostsByWord(keyword);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}

	@PostMapping("/image/upload/{postId}")
	public ResponseEntity<PostDto> fileUpload(@RequestParam("image") MultipartFile image, @PathVariable Long postId)
			throws IOException {
		PostDto postDto = postService.getSinglePost(postId);
		String fileName = fileService.uploadImage(path, image);
		postDto.setImageName(fileName);
		PostDto updatedPostDto = postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPostDto, HttpStatus.OK);
	}

	// method to serve file
	@GetMapping(value = "image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName, HttpServletResponse httpServletResponse)
			throws IOException {
		InputStream inputStream = fileService.getResource(path, imageName);
		httpServletResponse.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
	}
}