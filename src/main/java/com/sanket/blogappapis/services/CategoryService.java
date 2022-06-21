package com.sanket.blogappapis.services;

import java.util.List;

import com.sanket.blogappapis.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

	void deleteCategory(Long id);

	CategoryDto getOneCategory(Long id);

	List<CategoryDto> getAllCategory();
}
