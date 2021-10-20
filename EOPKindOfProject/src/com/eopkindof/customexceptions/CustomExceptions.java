package com.eopkindof.customexceptions;

import java.util.List;

public class CustomExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExceptions(String message) {
		System.out.println(message);
	}
	public CustomExceptions(List<String> exceptionList) {
		for(String exception: exceptionList)
		System.out.println(exception);
	}
	public static CustomExceptions InvalidHeaderException(String vi, String field) {
		return new CustomExceptions("Header validation fails since field\t" + field + " fails " + vi + " validation");
	}

	public static CustomExceptions InvalidHeaderException() {
		return new CustomExceptions("Invalid Header: Empty Header or Header does not start with H");
	}

	public static CustomExceptions InvalidTrailerException(String vi, String field) {
		return new CustomExceptions("Trailer validation fails since field\t" + field + " fails " + vi + " validation");
	}

	public static CustomExceptions InvalidTrailerException() {
		return new CustomExceptions("Invalid Trailer: Empty Trailer or Trailer does not start with T");
	}

	public static CustomExceptions InvalidRecordException(String vi, String field) {
		return new CustomExceptions("Record validation fails since field\t" + field + " fails " + vi + " validation");
	}

	public static CustomExceptions InvalidRecordException() {
		return new CustomExceptions("Record validation fails: Empty Record or Record does not start with B");
	}
}
