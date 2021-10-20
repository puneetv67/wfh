package com.eopkindof.file.validate;

public interface FileValidator {

	String NUMERIC="N";
	String ALPHA="A";
	String APLHA_NUMERIC="AN";
	String ALPHA_NUMERIC_SPECIALCHARACTER="ANS";
	String DATETIME="DT";
	String BASE_DELIMETER="#";
	String MANDATORY="M";
	String Length="L";
	String SPECIFIC="S";
	boolean isNumeric(String field);
	boolean isAlpha(String field);
	boolean isAlphaNumeric(String field);
	boolean isAlphanumericSpecialCharacter(String field);
	boolean isDateTime(String field);
	boolean isMandatory(String field);
	boolean isLengthValid(String fieldName, String field);
	boolean isSpecificValue(String fieldName, String field);
	
}
