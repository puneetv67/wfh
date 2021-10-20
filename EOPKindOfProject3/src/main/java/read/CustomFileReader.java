package main.java.read;

import java.nio.file.Path;
import java.util.Properties;

public interface CustomFileReader {
	final String INPUT_FOLDER=".inputfolder";
	final String ARCHIVE_FOLDER=".archivefolder";
	final String PENDING_FOLDER=".pendingfolder";
	final String INVALID_FOLDER=".invalidfolder";
	final String EXCEPTION_FOLDER=".exceptionfolder";
	final String VALIDATION="validation.";
	final String length="length.";
	void moveFileToDestinationFolder(Path source, Path destination);
	void fileReader(Properties fileSytemProperties, Properties fileProperties, String fileName);

}
