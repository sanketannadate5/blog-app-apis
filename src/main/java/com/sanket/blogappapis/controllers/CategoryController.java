package com.sanket.blogappapis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.blogappapis.payloads.CategoryDto;
import com.sanket.blogappapis.services.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable ("CategoryId") Long CategoryId){
		CategoryDto categoryDto = categoryService.getOneCategory(CategoryId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.ACCEPTED);
	}
}
