package com.sanket.blogappapis.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryDto {
	private Long id;
	
	@NotBlank
	@Size(min = 4)
	private String title;
	@NotBlank
	@Size(min = 6)
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
