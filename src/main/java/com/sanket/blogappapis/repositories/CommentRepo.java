package com.sanket.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.blogappapis.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
