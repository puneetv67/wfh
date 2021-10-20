package com.eopkindof.file.field.validation.mapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileFieldValidationMapping<T> {
	private HashMap<String,HashMap<String,List<String>>> fileFieldValidationMap = new HashMap<>();
	private HashMap<String, List<String>> fieldValidationMap = new HashMap<>();
	
	
	public HashMap<String, HashMap<String, List<String>>> getFileFieldValidationMap() {
		return fileFieldValidationMap;
	}


	/*public HashMap<String, List<String>> getFieldValidationMap() {
		return fieldValidationMap;
	}*/


	public void setMap(HashMap<?, ?> map) {
		fieldValidationMap.put("RecordId", Arrays.asList("M,N,L"));
		fieldValidationMap.put("Country", Arrays.asList("M,A,L"));
		fieldValidationMap.put("FirstName", Arrays.asList("M,A,L"));
		fieldValidationMap.put("LastName", Arrays.asList("M,A,L"));
		fieldValidationMap.put("Sport", Arrays.asList("M,A,L"));
		fieldValidationMap.put("Medal", Arrays.asList("M,A,L"));
		fieldValidationMap.put("Olympic", Arrays.asList("M,AN,L"));
		
		fileFieldValidationMap.put("101POC001",fieldValidationMap);
	}
}
