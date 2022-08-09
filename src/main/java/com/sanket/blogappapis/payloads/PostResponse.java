package com.sanket.blogappapis.payloads;

import java.util.List;

public class PostResponse {
	
	private List<PostDto> postContent;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private Boolean isLastPage;
	
	public List<PostDto> getPostContent() {
		return postContent;
	}
	public void setPostContent(List<PostDto> postContent) {
		this.postContent = postContent;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Boolean getIsLastPage() {
		return isLastPage;
	}
	public void setIsLastPage(Boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
}