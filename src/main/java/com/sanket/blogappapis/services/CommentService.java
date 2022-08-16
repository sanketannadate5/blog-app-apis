package com.sanket.blogappapis.services;

import com.sanket.blogappapis.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Long postId, Long uerId);

	void deleteComment(Long commentId);

}
