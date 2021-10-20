package main.java.PatternBasedValidationTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import main.java.customexceptions.CustomExceptions;
import main.java.validate.FileValidatorImpl;

public class CSVPatternTemplateImpl extends FileValidatorImpl implements CSVPatternTemplate {

	@Override
	public boolean validateCSVHeader(String header, List<String> headerExceptions,
			HashMap<String, Object> fieldValidationMap, HashMap<String, Object> fieldLengthMap)
			throws CustomExceptions, NullPointerException, Exception {

		if (header == null || header.isEmpty() || !header.startsWith("H")) {
			throw CustomExceptions.invalidHeaderException();
		}
		String[] split = header.substring(2, header.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] fieldValidationMapper = keyValue.split(BASE_DELIMETER);
			validate(fieldValidationMapper[0], fieldValidationMapper[1], headerExceptions, fieldValidationMap,
					fieldLengthMap);
		}
		return (headerExceptions==null||headerExceptions.isEmpty())?true:false;

	}

	@Override
	public boolean validateCSVTrailer(String trailer, List<String> trailerExceptions,
			HashMap<String, Object> fieldValidationMap, HashMap<String, Object> fieldLengthMap)
			throws CustomExceptions, NullPointerException, Exception {
		if (trailer == null || trailer.isEmpty() || !trailer.startsWith("T")) {
			throw CustomExceptions.invalidTrailerException();
		}
		String[] split = trailer.substring(2, trailer.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] fieldValidationMapper = keyValue.split(BASE_DELIMETER);
			validate(fieldValidationMapper[0], fieldValidationMapper[1], trailerExceptions, fieldValidationMap,
					fieldLengthMap);
		}
		return (trailerExceptions==null||trailerExceptions.isEmpty())?true:false;
	}

	@Override
	public boolean validateCSVRecord(String record, List<String> recordExceptions,
			HashMap<String, Object> fieldValidationMap, HashMap<String, Object> fieldLengthMap)
			throws CustomExceptions, NullPointerException, Exception {
		if (record == null || record.isEmpty() || !record.startsWith("B")) {
			throw CustomExceptions.invalidRecordException();
		}
		String[] split = record.substring(2, record.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] fieldValidationMapper = keyValue.split(BASE_DELIMETER);
			validate(fieldValidationMapper[0], fieldValidationMapper[1], recordExceptions, fieldValidationMap,
					fieldLengthMap);
		}
		return (recordExceptions==null||recordExceptions.isEmpty())?true:false;
	}

	private void validate(String fieldName, String field, List<String> exceptions,
			HashMap<String, Object> fieldValidationMap, HashMap<String, Object> fieldLengthMap)
			throws NullPointerException {
		boolean outcome = false;
		String exceptionMessage;
		System.out.println("fieldName\t" + fieldName);
		if (fieldValidationMap.get(fieldName) != null) {
			List<String> listOfValidations = Arrays
					.asList(fieldValidationMap.get(fieldName).toString().split(COMMA_DELIMETER));

			for (String validation : listOfValidations) {
				switch (validation) {
				case "A":
					outcome = isAlpha(field);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "contains letters other than alphabet";
						exceptions.add(exceptionMessage);
					}
					break;
				case "N":
					outcome = isNumeric(field);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "is not numeric";
						exceptions.add(exceptionMessage);
					}
					break;
				case "AN":
					outcome = isAlphaNumeric(field);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "is not alphanumeric";
						exceptions.add(exceptionMessage);
					}
					break;
				case "ANS":
					outcome = isAlphanumericSpecialCharacter(field);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "contains letters other than alphabet/numbers/special characters";
						exceptions.add(exceptionMessage);
					}
					break;
				case "DT":
					outcome = isDateTime(field);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "is not valid timeestamp";
						exceptions.add(exceptionMessage);
					}
					break;
				case "M":
					outcome = isMandatory(field);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "mandatory field not provided in file";
						exceptions.add(exceptionMessage);
					}
					break;
				case "L":
					outcome = isLengthValid(fieldName, field, fieldLengthMap);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "invalid length";
						exceptions.add(exceptionMessage);
					}
					break;
				case "S":
					outcome = isSpecificValue(fieldName, field);
					if (!outcome) {
						exceptionMessage = "FieldName:\t" + fieldName + " \tValue provided:\t" + field
								+ " \tException:\t" + "contains value other than allowed";
						exceptions.add(exceptionMessage);
					}
					break;
				default:
					System.out.println("Invalid validation identifier for field: " + fieldName + " provided in file.");
					exceptionMessage = "Invalid validation identifier for field: " + fieldName + " provided in file.";
					exceptions.add(exceptionMessage);
				}
			}
		} else {
				exceptions.add("validation corresponding to "+fieldName +" missing");
		}
	}

}
