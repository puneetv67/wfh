package com.eopkindof.file.field.validation.mapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileFieldValidationMapping {
	private static HashMap<String,HashMap<String,List<String>>> fileFieldValidationMap = new HashMap<>();
	private static HashMap<String, List<String>> fieldValidationMap = new HashMap<>();
	private static HashMap<String,Integer> fieldLengthMap = new HashMap<>();
	
	public HashMap<String, HashMap<String, List<String>>> getFileFieldValidationMap() {
		return fileFieldValidationMap;
	}


	/*public HashMap<String, List<String>> getFieldValidationMap() {
		return fieldValidationMap;
	}*/


	public void setMap() {
		fieldValidationMap.put("RecordId", Arrays.asList("M","N","L"));
		fieldValidationMap.put("Country", Arrays.asList("M","A","L"));
		fieldValidationMap.put("FirstName", Arrays.asList("M","A","L"));
		fieldValidationMap.put("LastName", Arrays.asList("M","A","L"));
		fieldValidationMap.put("Sport", Arrays.asList("M","A","L"));
		fieldValidationMap.put("Medal", Arrays.asList("M","A","L"));
		fieldValidationMap.put("Olympic", Arrays.asList("M","AN","L"));
		fieldValidationMap.put("Timestamp", Arrays.asList("M","DT"));
		fieldValidationMap.put("FileId", Arrays.asList("M","AN","L","S"));
		fieldValidationMap.put("CountOfRecords", Arrays.asList("M","N","L","S"));
		
		fileFieldValidationMap.put("101POC001",fieldValidationMap);
		
		fieldLengthMap.put("RecordId",15);
		fieldLengthMap.put("Country",30);
		fieldLengthMap.put("FirstName",15);
		fieldLengthMap.put("LastName",20);
		fieldLengthMap.put("Sport",10);
		fieldLengthMap.put("Medal",6);
		fieldLengthMap.put("Olympic",30);
		fieldLengthMap.put("Timestamp",10);
		fieldLengthMap.put("FileId",10);
		fieldLengthMap.put("CountOfRecords",15);
		
	}


	public HashMap<String, List<String>> getFieldValidationMap() {
		return fieldValidationMap;
	}


	public HashMap<String, Integer> getFieldLengthMap() {
		return fieldLengthMap;
	}
}
