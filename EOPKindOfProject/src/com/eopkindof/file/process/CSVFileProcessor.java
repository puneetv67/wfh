package com.eopkindof.file.process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.eopkindof.customexceptions.CustomExceptions;
import com.eopkindof.file.read.CustomFileReader;

import PatternBasedValidationTemplate.CSVPatternTemplateImpl;

public class CSVFileProcessor extends CSVPatternTemplateImpl implements CustomFileReader {

	@Override
	public void moveFileToDestinationFolder(Path source, Path destination) {
		try {
			Files.move(source, destination, StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fileReader(String fileName) {
		List<String> headerExceptions = new ArrayList<>();
		List<String> trailerExceptions = new ArrayList<>();
		List<String> recordExceptions = new ArrayList<>();
		String inputFile = INPUT_FOLDER + fileName;
		System.out.println(" Print complete file path " + inputFile);
		Path source = null;
		Path destinationArchive = null;
		Path destinationInvalid = null;
		boolean isValidHeader = false;
		boolean isValidTrailer = false;
		boolean isValidRecord = false;
		try (FileWriter fw = new FileWriter(new File(EXCEPTION_FOLDER+"exceptions.txt"))){
			source = Paths.get(inputFile);
			System.out.println("source is " + source);
			destinationArchive = Paths.get(ARCHIVE_FOLDER + fileName);
			destinationInvalid = Paths.get(INVALID_FOLDER + fileName);
			List<String> readAllLines = Files.readAllLines(source);
			isValidHeader = validateCSVHeader(readAllLines.get(0), headerExceptions);
			isValidTrailer = validateCSVTrailer(readAllLines.get(readAllLines.size() - 1), trailerExceptions);
			if (isValidHeader && isValidTrailer) {
				List<String> records = readAllLines;
				records.remove(0);
				records.remove(records.size() - 1);
				for (String record : records) {
					isValidRecord = validateCSVRecord(record, recordExceptions);
				}
			}
			if (headerExceptions != null && !headerExceptions.isEmpty()) {
				fw.append("Header Exceptions:\n");
				for (String he : headerExceptions) {
					fw.append(he+"\n");
				}
			}
			if (trailerExceptions != null && !trailerExceptions.isEmpty()) {
				fw.append("Trailer Exceptions:\n");
				for (String te : trailerExceptions) {
					fw.append(te+"\n");
				}
			}
			if (recordExceptions != null && !recordExceptions.isEmpty()) {
				fw.write("Record Exceptions:\n");
				for (String re : recordExceptions) {
					fw.write(re+"\n");
				}
			}
			if ((headerExceptions != null && !headerExceptions.isEmpty())
					|| (trailerExceptions != null && !trailerExceptions.isEmpty())
					|| (recordExceptions != null && !recordExceptions.isEmpty())) {
				System.out.println(" File " + fileName + " is invalid hence moved to invalid folder");
				moveFileToDestinationFolder(source, destinationInvalid);
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

		catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
