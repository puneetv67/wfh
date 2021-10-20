package com.eopkindof.file.read;

import java.nio.file.Path;

public interface CustomFileReader {
	final String INPUT_FOLDER="D:\\JavaPrograms\\File\\cmp\\input\\";
	final String OUTPUT_FOLDER="D:\\JavaPrograms\\File\\cmp\\output\\";
	final String PENDING_FOLDER="D:\\JavaPrograms\\File\\cmp\\pending\\";
	final String INVALID_FOLDER="D:\\JavaPrograms\\File\\cmp\\invalid\\";
	void fileReader(String fileName);
	void moveFileToDestinationFolder(Path source, Path destination);

}
