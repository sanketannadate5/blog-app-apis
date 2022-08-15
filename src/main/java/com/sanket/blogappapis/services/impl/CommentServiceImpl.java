package com.sanket.blogappapis.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.blogappapis.entity.Comment;
import com.sanket.blogappapis.entity.Post;
import com.sanket.blogappapis.exceptions.ResourceNotFoundException;
import com.sanket.blogappapis.payloads.CommentDto;
import com.sanket.blogappapis.repositories.CommentRepo;
import com.sanket.blogappapis.repositories.PostRepo;
import com.sanket.blogappapis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepo commentRepo;

	@Autowired
	PostRepo postRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Long postId) {

		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

		Comment comment = modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);

		Comment savedComment = commentRepo.save(comment);

		return modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Long commentId) {
		Comment comment = commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		commentRepo.delete(comment);
	}

}
