package com.slk.synkmanagement.customexception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6231469283454239045L;
	private String resourceName;
	private Integer fieldValue;
	private String fieldName;

	public ResourceNotFoundException(String resourceName, Integer fieldValue, String fieldName) {
		super(String.format("%s with %s not found for : %s", resourceName, fieldName, fieldValue));
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.resourceName = resourceName;

	}

}
