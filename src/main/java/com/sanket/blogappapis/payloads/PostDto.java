package com.sanket.blogappapis.payloads;

import java.sql.Timestamp;

import com.sanket.blogappapis.entity.Category;
import com.sanket.blogappapis.entity.User;

public class PostDto {

	private String title;
	private String content;
	private String imageName; 
	private Timestamp addedDate;
	private User user;
	private Category category;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Timestamp getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Timestamp addedDate) {
		this.addedDate = addedDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}	
}
