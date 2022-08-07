package com.sanket.blogappapis.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.sanket.blogappapis.payloads.ApiResponse;
import com.sanket.blogappapis.payloads.PostDto;
import com.sanket.blogappapis.services.PostService;

@RestController
@RequestMapping("api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Long userId,
			@PathVariable Long categoryId) {
		return new ResponseEntity<PostDto>(postService.createPost(postDto,userId,categoryId), HttpStatus.CREATED);
	}

	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updateCategory(@Valid @RequestBody PostDto postDto,@PathVariable ("postId") Long postId){
		return new ResponseEntity<PostDto>(postService.updatePost(postDto, postId),HttpStatus.CREATED);
	}

	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponse> deletePostById(@PathVariable ("postId") Long postId){
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted Successfully !!",true),HttpStatus.OK);
	}


	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable ("postId") Long postId){
		PostDto postDto = postService.getSinglePost(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.ACCEPTED);
	}

	@GetMapping("/")
	public ResponseEntity<List<PostDto>> getAllpost(
			@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize) {
		List<PostDto> postDtos = postService.getAllPost(pageNumber, pageSize);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}/user")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId){
		List<PostDto> postDtos = postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}/category")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId){
		List<PostDto> postDtos = postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
}