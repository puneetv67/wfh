package com.puneet.file;

import java.util.List;

public interface ReadFileUtility {

	String FILE_INPUT_PATH = "D:\\JavaPrograms\\File\\txt\\cmdforRam.txt";
	String CSV_FILE_INPUT_PATH = "D:\\JavaPrograms\\File\\csv\\sports.csv";
	String FILE_OUTPUT_PATH = "D:\\JavaPrograms\\File\\outputVer2\\";
	String COMMA_DELIMITER = ",";
	void readFile(String choice);
	<T> void printList (List<T> t);
}
