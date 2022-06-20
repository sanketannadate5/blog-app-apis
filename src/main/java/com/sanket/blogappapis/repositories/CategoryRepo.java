package com.sanket.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.blogappapis.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
	
}
