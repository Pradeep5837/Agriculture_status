package com.agriculture.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(resourceName+" not found with the value "+fieldName+" : "+fieldValue);
		this.resourceName = resourceName; //employee
		this.fieldName = fieldName; //id
		this.fieldValue = fieldValue; //2,1,3
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

