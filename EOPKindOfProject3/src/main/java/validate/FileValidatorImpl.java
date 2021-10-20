package main.java.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;

import main.java.mapping.FileFieldValidationMapping;

public class FileValidatorImpl implements FileValidator {

	@Override
	public boolean isNumeric(String field) {
		 if (field == null || field.length() == 0|| field.isEmpty()) {
	            return false;
	        }

	        return field.chars().allMatch(Character::isDigit);
	}
	
	@Override
	public boolean isAlpha(String field) {
		 if (field == null || field.length() == 0|| field.isEmpty()) {
	            return false;
	        }

	        return field.chars().allMatch(Character::isLetter);
	}


	@Override
	public boolean isAlphaNumeric(String field) {
		 if (field == null || field.length() == 0|| field.isEmpty()) {
	            return false;
	        }

	        return field.chars().allMatch(Character::isLetterOrDigit);
	}

	@Override
	public boolean isAlphanumericSpecialCharacter(String field) {
		 if (field == null || field.length() == 0|| field.isEmpty()) {
	            return false;
	        }

	        return field.chars().allMatch(Character::isUnicodeIdentifierPart);
	}

	@Override
	public boolean isDateTime(String field) {
		return true;
		/*String dateFormat = "yyyymmdd";
		boolean isValid=false;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(field, dateFormatter);
			isValid=true;
		} catch (DateTimeParseException e) {
			isValid=false;
			e.printStackTrace();
		}

		return isValid;
*/	}

	@Override
	public boolean isMandatory(String field) {
		return field!=null && !field.isEmpty();
	}

	@Override
	public boolean isLengthValid(String fieldName, String field, HashMap<String, Object> fieldLengthMap) {
		int maxLengthSupported = Integer.parseInt(fieldLengthMap.get(fieldName).toString());
		return field.length()<=maxLengthSupported;
	}

	@Override
	public boolean isSpecificValue(String fieldName, String field) {
		return true;
	}
}
