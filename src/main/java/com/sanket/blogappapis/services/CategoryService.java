package com.sanket.blogappapis.services;

import java.util.List;

import com.sanket.blogappapis.entity.Category;

public interface CategoryService {
	
	Category createCategory();
	
	Category updateCategory(Long id);
	
	void deleteCategory(Long id);
	
	Category getOneCategory(Long id);
	
	List<Category> getAllCategory();
}
