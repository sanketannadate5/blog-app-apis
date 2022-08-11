package com.sanket.blogappapis.payloads;

public class ImageResponse {
	
	private String fileName;
	private String message;
	
	public ImageResponse() {
	}
	
	public ImageResponse(String fileName, String message) {
		
		this.fileName = fileName;
		this.message = message;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
