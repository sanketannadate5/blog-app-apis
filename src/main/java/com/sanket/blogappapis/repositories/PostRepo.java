package com.sanket.blogappapis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.blogappapis.entity.Category;
import com.sanket.blogappapis.entity.Post;
import com.sanket.blogappapis.entity.User;

public interface PostRepo extends JpaRepository<Post, Long> {
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
}
