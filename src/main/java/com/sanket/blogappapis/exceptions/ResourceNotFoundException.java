package com.sanket.blogappapis.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5137375964377182039L;
	//	String resourceName;
	//	String fieldName;
	//	Long fieldId;

	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldId) {
		super(String.format("%s not found with %s : %s ", resourceName, fieldName, fieldId));
		//		this.resourceName = resourceName;
		//		this.fieldName = fieldName;
		//		this.fieldId = fieldId;
	}

}
