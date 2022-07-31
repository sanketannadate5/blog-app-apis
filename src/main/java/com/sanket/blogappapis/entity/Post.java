package com.sanket.blogappapis.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pt_id")
	private Long postId;
	
	@Column(name = "pt_title", length = 20)
	private String title;
	
	@Column(name = "pt_content", length = 100)	
	private String content;
	
	@Column(name = "pt_imgName", length = 20)	
	private String imageName;
	
	@Column(name = "pt_data")
	private Timestamp addedDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "ctg_id")
	private Category category;

//	@JoinColumn(name = "ctg_id")
//	@JsonManagedReference
//	@JoinColumn(name = "user_id")
//	@JsonBackReference
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
