package com.sanket.blogappapis.payloads;

public class ApiResponse {
	
	private String message;
	private Boolean flag;
	
	
	public ApiResponse() {
		super();
	}


	public ApiResponse(String message, Boolean flag) {
		super();
		this.message = message;
		this.flag = flag;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Boolean getFlag() {
		return flag;
	}


	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}
