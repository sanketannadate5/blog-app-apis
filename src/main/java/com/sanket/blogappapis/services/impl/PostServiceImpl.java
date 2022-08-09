package com.sanket.blogappapis.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sanket.blogappapis.entity.Category;
import com.sanket.blogappapis.entity.Post;
import com.sanket.blogappapis.entity.User;
import com.sanket.blogappapis.exceptions.ResourceNotFoundException;
import com.sanket.blogappapis.payloads.PostDto;
import com.sanket.blogappapis.payloads.PostResponse;
import com.sanket.blogappapis.repositories.CategoryRepo;
import com.sanket.blogappapis.repositories.PostRepo;
import com.sanket.blogappapis.repositories.UserRepo;
import com.sanket.blogappapis.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));

		Post post = modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Timestamp(System.currentTimeMillis()));
		post.setUser(user);
		post.setCategory(category);
		return modelMapper.map(postRepo.save(post), PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Long id) {
		Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", id));
		post.setTitle(postDto.getTitle());
//		post.setUser(post.getUser());
		post.setContent(postDto.getContent());
		return this.modelMapper.map(postRepo.save(post), PostDto.class);
	}

	@Override
	public PostDto getSinglePost(Long id) {
		Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", id));
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection) {
		
		Sort sort = sortDirection.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
	    
		Page<Post> pagePosts = postRepo.findAll(pageable);
		
	    List<Post> posts = pagePosts.getContent();
		List<PostDto> listOfPostDTO = posts.stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		
		postResponse.setPostContent(listOfPostDTO);
		postResponse.setPageNumber(pagePosts.getNumber());
		postResponse.setPageSize(pagePosts.getSize());
		postResponse.setTotalElements(pagePosts.getTotalElements());
		postResponse.setTotalPages(pagePosts.getTotalPages());
		postResponse.setIsLastPage(pagePosts.isLast());
		
		return postResponse;
	}

	@Override
	public void deletePost(Long id) {
		Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", id));
		postRepo.delete(post);
	}

	@Override
	public List<PostDto> getPostsByCategory(Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		List<Post> posts = postRepo.findByCategory(category);
		return posts.stream().map((post) -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostsByUser(Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = postRepo.findByUser(user);
		return posts.stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> searchPostsByWord(String keyword) {
		List<Post> posts = postRepo.findByTitleContaining(keyword);
		return  posts.stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}
}
