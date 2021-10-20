package PatternBasedValidationTemplate;

import com.eopkindof.customexceptions.CustomExceptions;
import com.eopkindof.file.vallidate.FileValidator;

public interface CSVPatternTemplate extends FileValidator{
	String COMMA_DELIMETER=",";
	boolean validateCSVHeader(String header) throws CustomExceptions, Exception;
	boolean validateCSVTrailer(String trailer) throws CustomExceptions, Exception;
	boolean validateCSVRecord(String record) throws CustomExceptions, Exception;
}
