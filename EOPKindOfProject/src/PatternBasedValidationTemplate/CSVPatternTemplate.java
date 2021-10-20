package PatternBasedValidationTemplate;

import java.util.List;

import com.eopkindof.customexceptions.CustomExceptions;
import com.eopkindof.file.validate.FileValidator;

public interface CSVPatternTemplate extends FileValidator{
	String COMMA_DELIMETER=",";
	boolean validateCSVHeader(String header, List<String> headerExceptions) throws CustomExceptions, Exception;
	boolean validateCSVTrailer(String trailer, List<String> trailerException) throws CustomExceptions, Exception;
	boolean validateCSVRecord(String record, List<String> recordExceptions) throws CustomExceptions, Exception;
}
