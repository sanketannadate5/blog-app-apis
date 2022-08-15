package com.sanket.blogappapis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.blogappapis.payloads.ApiResponse;
import com.sanket.blogappapis.payloads.CommentDto;
import com.sanket.blogappapis.services.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/post/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Long postId) {
		CommentDto commentDtoupdated = commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(commentDtoupdated, HttpStatus.CREATED);
	}

	@DeleteMapping("/{commentId}")
	public ResponseEntity<ApiResponse> createComment(@PathVariable Long postId) {
		commentService.deleteComment(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !!!", true),
				HttpStatus.OK);
	}
}