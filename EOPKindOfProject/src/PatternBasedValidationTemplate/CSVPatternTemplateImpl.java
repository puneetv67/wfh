package PatternBasedValidationTemplate;

import java.util.List;

import com.eopkindof.customexceptions.CustomExceptions;
import com.eopkindof.file.field.validation.mapping.FileFieldValidationMapping;
import com.eopkindof.file.validate.FileValidatorImpl;

public class CSVPatternTemplateImpl extends FileValidatorImpl implements CSVPatternTemplate {
	
	
	@Override
	public boolean validateCSVHeader(String header, List<String> headerExceptions) throws CustomExceptions, Exception {
		
		if (header == null || header.isEmpty() || !header.startsWith("H")) {
			throw CustomExceptions.InvalidHeaderException();
		}
		String[] split = header.substring(2, header.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] fieldValidationMapper = keyValue.split(BASE_DELIMETER);
			validate(fieldValidationMapper[0], fieldValidationMapper[1],headerExceptions);
		}
		return true;

	}

	@Override
	public boolean validateCSVTrailer(String trailer, List<String> trailerExceptions) throws CustomExceptions, Exception {
		if (trailer == null || trailer.isEmpty() || !trailer.startsWith("T")) {
			throw CustomExceptions.InvalidTrailerException();
		}
		String[] split = trailer.substring(2, trailer.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] fieldValidationMapper = keyValue.split(BASE_DELIMETER);
			validate(fieldValidationMapper[0], fieldValidationMapper[1],trailerExceptions);
		}
		return true;
	}

	@Override
	public boolean validateCSVRecord(String record, List<String> recordExceptions) throws CustomExceptions, Exception {
		if (record == null || record.isEmpty() || !record.startsWith("B")) {
			throw CustomExceptions.InvalidRecordException();
		}
		String[] split = record.substring(2, record.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] fieldValidationMapper = keyValue.split(BASE_DELIMETER);
			validate(fieldValidationMapper[0], fieldValidationMapper[1],recordExceptions);
		}
		return true;
	}

	private void validate(String fieldName, String field, List<String> exceptions) {
		boolean outcome=false;
		String exceptionMessage;
		FileFieldValidationMapping obj = new FileFieldValidationMapping();
		obj.setMap();
		List<String> listOfValidations = obj.getFieldValidationMap().get(fieldName);
		for (String validation : listOfValidations) {
			switch (validation) {
			case "A":
				outcome=isAlpha(field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "contains letters other than alphabet";
					exceptions.add(exceptionMessage);
				}
				break;
			case "N":
				outcome=isNumeric(field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "is not numeric";
					exceptions.add(exceptionMessage);
				}
				break;
			case "AN":
				outcome=isAlphaNumeric(field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "is not alphanumeric";
					exceptions.add(exceptionMessage);
				}
				break;
			case "ANS":
				outcome=isAlphanumericSpecialCharacter(field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "contains letters other than alphabet/numbers/special characters";
					exceptions.add(exceptionMessage);
				}
				break;
			case "DT":
				outcome=isDateTime(field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "is not valid timeestamp";
					exceptions.add(exceptionMessage);
				}
				break;
			case "M":
				outcome=isMandatory(field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "mandatory field not provided in file";
					exceptions.add(exceptionMessage);
				}
				break;
			case "L":
				outcome=isLengthValid(fieldName,field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "invalid length";
					exceptions.add(exceptionMessage);
				}
				break;
			case "S":
				outcome=isSpecificValue(fieldName,field);
				if(!outcome){
					exceptionMessage="FieldName:\t" + fieldName + " \tValue provided:\t" + field +" \tException:\t" + "contains value other than allowed";
					exceptions.add(exceptionMessage);
				}
				break;
			default:
				System.out.println(
						"Invalid validation identifier for field: " + fieldName + " provided in file.");
				exceptionMessage="Invalid validation identifier for field: " + fieldName + " provided in file.";
				exceptions.add(exceptionMessage);
			}
		}
		//return exceptions;
	}

}
