package PatternBasedValidationTemplate;

import com.eopkindof.customexceptions.CustomExceptions;
import com.eopkindof.file.vallidate.FileValidatorImpl;

public class CSVPatternTemplateImpl extends FileValidatorImpl implements CSVPatternTemplate {

	@Override
	public boolean validateCSVHeader(String header) throws CustomExceptions, Exception {
		if (header == null || header.isEmpty() || !header.startsWith("H")) {
			throw CustomExceptions.InvalidHeaderException();
		}
		String[] split = header.substring(2, header.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] validationIdentifierMapper = keyValue.split(BASE_DELIMETER);
			boolean isValid = validate(validationIdentifierMapper[0], validationIdentifierMapper[1]);
			if (!isValid) {
				throw CustomExceptions.InvalidHeaderException(validationIdentifierMapper[0],
						validationIdentifierMapper[1]);
			}
		}
		return true;

	}
	@Override
	public boolean validateCSVTrailer(String trailer) throws CustomExceptions, Exception {
		if (trailer == null || trailer.isEmpty() || !trailer.startsWith("T")) {
			throw CustomExceptions.InvalidTrailerException();
		}
		String[] split = trailer.substring(2, trailer.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] validationIdentifierMapper = keyValue.split(BASE_DELIMETER);
			boolean isValid = validate(validationIdentifierMapper[0], validationIdentifierMapper[1]);
			if (!isValid) {
				throw CustomExceptions.InvalidTrailerException(validationIdentifierMapper[0],
						validationIdentifierMapper[1]);
			}
		}
		return true;
	}

	@Override
	public boolean validateCSVRecord(String record) throws CustomExceptions,Exception {
		if (record == null || record.isEmpty() || !record.startsWith("B")) {
			throw CustomExceptions.InvalidRecordException();
		}
		String[] split = record.substring(2, record.length()).split(COMMA_DELIMETER);
		for (String keyValue : split) {
			String[] validationIdentifierMapper = keyValue.split(BASE_DELIMETER);
			boolean isValid = validate(validationIdentifierMapper[0], validationIdentifierMapper[1]);
			if (!isValid) {
				throw CustomExceptions.InvalidRecordException(validationIdentifierMapper[0],
						validationIdentifierMapper[1]);
			}
		}
		return true;
	}

	private boolean validate(String validationIdentifier, String field) {
		switch (validationIdentifier) {
		case "A":
			return isAlpha(field);
		case "N":
			return isNumeric(field);
		case "AN":
			return isAlphaNumeric(field);
		case "ANS":
			return isAlphanumericSpecialCharacter(field);
		case "DT":
			return isDateTime(field);
		default:
			System.out.println("Header is invalid as validation identifier: " + validationIdentifier + " provided in file is invalid");
			return false;
		}
	}

	
}
