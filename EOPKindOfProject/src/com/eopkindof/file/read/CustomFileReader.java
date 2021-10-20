package com.eopkindof.file.read;

import java.nio.file.Path;

public interface CustomFileReader {
	final String INPUT_FOLDER="D:\\JavaPrograms\\File\\cmp\\input\\";
	final String ARCHIVE_FOLDER="D:\\JavaPrograms\\File\\cmp\\archive\\";
	final String PENDING_FOLDER="D:\\JavaPrograms\\File\\cmp\\pending\\";
	final String INVALID_FOLDER="D:\\JavaPrograms\\File\\cmp\\invalid\\";
	final String EXCEPTION_FOLDER="D:\\JavaPrograms\\File\\cmp\\exception\\";
	void fileReader(String fileName);
	void moveFileToDestinationFolder(Path source, Path destination);

}
