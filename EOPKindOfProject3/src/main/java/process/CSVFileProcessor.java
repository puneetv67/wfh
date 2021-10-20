package main.java.process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import main.java.PatternBasedValidationTemplate.CSVPatternTemplateImpl;
import main.java.customexceptions.CustomExceptions;
import main.java.mapping.FileFieldValidationMapping;
import main.java.read.CustomFileReader;

public class CSVFileProcessor extends CSVPatternTemplateImpl implements CustomFileReader {

	List<String> headerExceptions = new ArrayList<>();
	List<String> trailerExceptions = new ArrayList<>();
	List<String> recordExceptions = new ArrayList<>();
	String inputFile;
	String archiveFile;
	String pendingFile;
	String invalidFile;
	String exceptionFile;
	Logger logger = Logger.getLogger(CSVFileProcessor.class.getName());

	@Override
	public void moveFileToDestinationFolder(Path source, Path destination) {
		try {
			Path move = Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("moved to " + move);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fileReader(Properties fileSytemProperties, Properties fileProperties, String fileName) {

		// capturing config properties
		inputFile = (String) fileSytemProperties.get(fileName + INPUT_FOLDER);
		archiveFile = (String) fileSytemProperties.get(fileName + ARCHIVE_FOLDER);
		pendingFile = (String) fileSytemProperties.get(fileName + PENDING_FOLDER);
		invalidFile = (String) fileSytemProperties.get(fileName + INVALID_FOLDER);
		exceptionFile = (String) fileSytemProperties.get(fileName + EXCEPTION_FOLDER);
		System.out.println(" Print complete file path " + inputFile + "\t" + archiveFile + "\t" + pendingFile + "\t"
				+ invalidFile);

		HashMap<String, Object> fieldValidationMap = FileFieldValidationMapping.fieldValidationMap;
		HashMap<String, Object> fieldLengthMap = FileFieldValidationMapping.fieldLengthMap;
		// capturing file specific properties
		List<String> fieldList = Arrays.asList(fileProperties.get(fileName).toString().split(COMMA_DELIMETER));
		for (String field : fieldList) {
			fieldValidationMap.put(field, fileProperties.get(VALIDATION + field));
			fieldLengthMap.put(field, fileProperties.get(length + field));
		}

		Path source = null;
		Path destinationArchive = null;
		Path destinationPending = null;
		Path destinationInvalid = null;
		boolean isValidHeader = false;
		boolean isValidTrailer = false;
		boolean isValidRecord = false;
		try {
			source = Paths.get(inputFile);
			destinationArchive = Paths.get(archiveFile);
			destinationPending = Paths.get(pendingFile);
			destinationInvalid = Paths.get(invalidFile);
			System.out.println("source is " + source);
			List<String> readAllLines = Files.readAllLines(source);
			isValidHeader = validateCSVHeader(readAllLines.get(0), headerExceptions, fieldValidationMap,
					fieldLengthMap);
			isValidTrailer = validateCSVTrailer(readAllLines.get(readAllLines.size() - 1), trailerExceptions,
					fieldValidationMap, fieldLengthMap);
			if (isValidHeader && isValidTrailer) {
				List<String> records = readAllLines;
				records.remove(0);
				records.remove(records.size() - 1);
				for (String record : records) {
					isValidRecord = validateCSVRecord(record, recordExceptions, fieldValidationMap, fieldLengthMap);
				}
			}
			if(!(isValidHeader&&isValidTrailer&&isValidRecord)){
				System.out.println(" File " + fileName + " is invalid hence moved to invalid folder");
				moveFileToDestinationFolder(source, destinationInvalid);
				printExceptionsToFile(new File(exceptionFile),headerExceptions,trailerExceptions,recordExceptions);
			}
			else {
				System.out.println(" File " + fileName + " is valid hence moved to archive folder");
				moveFileToDestinationFolder(source, destinationArchive);
			}
		}

		catch (CustomExceptions e) {
			System.out.println(" File " + fileName + " is invalid hence moved to invalid folder");
			moveFileToDestinationFolder(source, destinationInvalid);
			e.printStackTrace();
		}

		catch (IOException ioe) {
			printExceptionsToFile(new File(exceptionFile),ioe);
		} catch (NullPointerException npe) {
			printExceptionsToFile(new File(exceptionFile),npe);
		} catch (Exception e) {
			printExceptionsToFile(new File(exceptionFile),e);
		}
	}

	public void printExceptionsToFile(File exceptionFile, Exception exception) {

		try (FileWriter fw = new FileWriter(exceptionFile)) {
					fw.write("****Exceptions************\n");
					fw.write(exception + "\n");
				}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printExceptionsToFile(File exceptionFile,List<String> headerExceptions, List<String> trailerExceptions, List<String> recordExceptions) {

		try (FileWriter fw = new FileWriter(exceptionFile)) {
			if (headerExceptions != null && !headerExceptions.isEmpty()) {
				fw.append("Header Exceptions:\n");
				for (String he : headerExceptions) {
					fw.append(he + "\n");
				}
			}
			if (trailerExceptions != null && !trailerExceptions.isEmpty()) {
				fw.append("Trailer Exceptions:\n");
				for (String te : trailerExceptions) {
					fw.append(te + "\n");
				}
			}
			if (recordExceptions != null && !recordExceptions.isEmpty()) {
				fw.write("Record Exceptions:\n");
				for (String re : recordExceptions) {
					fw.write(re + "\n");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
