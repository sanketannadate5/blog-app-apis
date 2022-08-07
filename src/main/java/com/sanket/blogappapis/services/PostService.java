package com.sanket.blogappapis.services;

import java.util.List;

import com.sanket.blogappapis.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto, Long userId, Long categoryId);

	PostDto updatePost(PostDto postDto, Long id);

	void deletePost(Long id);

	PostDto getSinglePost(Long id);

	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);

	List<PostDto> getPostsByCategory(Long id);

	List<PostDto> getPostsByUser(Long id);

	List<PostDto> searchPostsByWord(String keyword);

}
