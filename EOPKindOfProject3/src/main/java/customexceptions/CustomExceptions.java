package main.java.customexceptions;

public class CustomExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExceptions(String message) {
		System.out.println(message);
	}

	public static CustomExceptions invalidHeaderException() {
		return new CustomExceptions("Invalid Header: Empty Header or Header does not start with H");
	}

	public static CustomExceptions invalidTrailerException() {
		return new CustomExceptions("Invalid Trailer: Empty Trailer or Trailer does not start with T");
	}

	public static CustomExceptions invalidRecordException() {
		return new CustomExceptions("Record validation fails: Empty Record or Record does not start with B");
	}
	
	public static CustomExceptions fieldValidationConfigurationMissing(String message){
		return new CustomExceptions(message);
		
	}
}
