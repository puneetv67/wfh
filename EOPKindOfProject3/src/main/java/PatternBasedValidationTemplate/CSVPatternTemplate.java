package main.java.PatternBasedValidationTemplate;

import java.util.HashMap;
import java.util.List;

import main.java.customexceptions.*;
import main.java.validate.FileValidator;

public interface CSVPatternTemplate extends FileValidator{
	String COMMA_DELIMETER=",";
	boolean validateCSVHeader(String header, List<String> headerExceptions, HashMap<String, Object> fieldValidationMap,
			HashMap<String, Object> fieldLengthMap) throws CustomExceptions, Exception;
	boolean validateCSVTrailer(String trailer, List<String> trailerExceptions,
			HashMap<String, Object> fieldValidationMap, HashMap<String, Object> fieldLengthMap)
			throws CustomExceptions, Exception;
	boolean validateCSVRecord(String record, List<String> recordExceptions, HashMap<String, Object> fieldValidationMap,
			HashMap<String, Object> fieldLengthMap) throws CustomExceptions, Exception;
}
