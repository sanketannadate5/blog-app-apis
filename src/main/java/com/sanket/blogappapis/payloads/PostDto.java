package com.sanket.blogappapis.payloads;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class PostDto {
	
	
	private Long postId;
//	@NotEmpty
//	@Size(min = 3, message = "Name should be minimum of 3 character !!")
	private String title;
//	@NotEmpty
	private String content;
	
	private String imageName;
	
	private Timestamp addedDate;
//	@NotEmpty
 	private UserDto user;
//	@NotEmpty
	private CategoryDto category;
	
	private Set<CommentDto> commentDtos = new HashSet<>();
	
	
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
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
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public Set<CommentDto> getCommentDtos() {
		return commentDtos;
	}
	public void setCommentDtos(Set<CommentDto> commentDtos) {
		this.commentDtos = commentDtos;
	}
}
