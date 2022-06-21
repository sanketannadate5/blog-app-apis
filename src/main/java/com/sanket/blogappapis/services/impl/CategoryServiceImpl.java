package com.sanket.blogappapis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.blogappapis.payloads.CategoryDto;
import com.sanket.blogappapis.entity.Category;
import com.sanket.blogappapis.exceptions.ResourceNotFoundException;
import com.sanket.blogappapis.repositories.CategoryRepo;
import com.sanket.blogappapis.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		categoryRepo.save(category);
		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());

		Category category2 = categoryRepo.save(category);
		return modelMapper.map(category2, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		categoryRepo.delete(category);
	}

	@Override
	public CategoryDto getOneCategory(Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> allCategory = categoryRepo.findAll();
		List<CategoryDto> categoryDtos = allCategory.stream().map(cateory -> modelMapper.map(cateory, CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
	}

}
