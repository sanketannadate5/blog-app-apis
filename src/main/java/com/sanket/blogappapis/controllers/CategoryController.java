package com.sanket.blogappapis.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.blogappapis.payloads.ApiResponse;
import com.sanket.blogappapis.payloads.CategoryDto;
import com.sanket.blogappapis.services.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody  CategoryDto categoryDto){
		return new ResponseEntity<CategoryDto>(categoryService.createCategory(categoryDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable ("CategoryId") Long categoryId){
		return new ResponseEntity<CategoryDto>(categoryService.updateCategory(categoryDto, categoryId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{CategoryId}")
	public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable ("CategoryId") Long categoryId){
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully !!",true),HttpStatus.OK);
	}
	
	
	@GetMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable ("CategoryId") Long CategoryId){
		CategoryDto categoryDto = categoryService.getOneCategory(CategoryId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> categoryDto = categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(categoryDto,HttpStatus.ACCEPTED);
	}
	
	
	
}
