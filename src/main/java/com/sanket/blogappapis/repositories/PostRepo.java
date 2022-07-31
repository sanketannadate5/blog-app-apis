package com.sanket.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.blogappapis.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

}
