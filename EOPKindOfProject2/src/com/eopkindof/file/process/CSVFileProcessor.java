package com.eopkindof.file.process;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.eopkindof.customexceptions.CustomExceptions;
import com.eopkindof.file.read.CustomFileReader;

import PatternBasedValidationTemplate.CSVPatternTemplateImpl;

public class CSVFileProcessor extends CSVPatternTemplateImpl implements CustomFileReader{
	
	
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
		String inputFile = INPUT_FOLDER+fileName;
		System.out.println(" Print complete file path "+ inputFile);
		Path source = null;
		Path destinationOutput=null;
		Path destinationInvalid = null;
		boolean isValidHeader=false;
		boolean isValidTrailer=false;
		boolean isValidRecord=false;
		try {
			source = Paths.get(inputFile);
			System.out.println("source is " + source);
			destinationOutput = Paths.get(OUTPUT_FOLDER+fileName);
			destinationInvalid = Paths.get(INVALID_FOLDER+fileName);
			List<String> readAllLines = Files.readAllLines(source);
			isValidHeader = validateCSVHeader(readAllLines.get(0));
			isValidTrailer = validateCSVTrailer(readAllLines.get(readAllLines.size()-1));
			if(isValidHeader && isValidTrailer){
				List<String> records = readAllLines;
				records.remove(0);
				records.remove(records.size()-1);
				for(String record: records){
					isValidRecord=validateCSVRecord(record);
				}
			}
			if(isValidRecord){
				System.out.println(" File " + fileName + " is valid");
				moveFileToDestinationFolder(source, destinationOutput);
			}
		}
		
		catch (CustomExceptions e) {
			if(e instanceof CustomExceptions){
				moveFileToDestinationFolder(source, destinationInvalid);
			}
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}


}
