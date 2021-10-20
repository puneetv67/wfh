/**
 * 
 */
package main.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.rules.TemporaryFolder;

import java.util.List;
import main.java.process.CSVFileProcessor;

/**
 * @author abc
 *
 */
public class CSVFileProcessorTest {
	@Rule
	public TemporaryFolder destinationFolder = new TemporaryFolder();
	@Rule
	public TemporaryFolder sourceFolder = new TemporaryFolder();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * Test method for {@link main.java.process.CSVFileProcessor#moveFileToDestinationFolder(java.nio.file.Path, java.nio.file.Path)}.
	 */
	@Test
	public void testMoveFileToDestinationFolder() throws IOException{
		File testFile = new File("testcase.txt");
		CSVFileProcessor obj = new CSVFileProcessor();
		System.out.println("source folder " + sourceFolder.newFile(testFile.getName()).getPath());
		System.out.println("destination folder " + destinationFolder.getRoot().toPath());
		Path path = sourceFolder.newFile("test3.txt").toPath();
		Path path2 = destinationFolder.newFile("test3.txt").toPath();
		obj.moveFileToDestinationFolder(path, path2);
		assertTrue("File exists", Files.exists(path2));
	}

	/**
	 * Test method for {@link main.java.process.CSVFileProcessor#fileReader(java.util.Properties, java.util.Properties, java.lang.String)}.
	 */
	@Test
	@Disabled
	public void testFileReader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link main.java.process.CSVFileProcessor#printExceptionsToFile(java.lang.Exception)}.
	 */
	@Test
	//@Disabled
	public void testPrintExceptionsToFileException() {
		CSVFileProcessor obj = new CSVFileProcessor();
		File exceptionFile = new File("testexception.txt");
		System.out.println(exceptionFile.getAbsolutePath());
		NullPointerException npe = new NullPointerException("Should be written to exception file");
		obj.printExceptionsToFile(exceptionFile,npe);
	}

	/**
	 * Test method for {@link main.java.process.CSVFileProcessor#printExceptionsToFile()}.
	 */
	@Test
	//@Disabled
	public void testPrintExceptionsToFile() {
		CSVFileProcessor obj = new CSVFileProcessor();
		File exceptionFile = new File("testexception2.txt");
		List<String> headerExceptionList = Arrays.asList("H missing");
		List<String> trailerExceptionList = Arrays.asList("H missing");
		List<String> recordExceptionList = Arrays.asList("H missing");
		obj.printExceptionsToFile(exceptionFile,headerExceptionList,trailerExceptionList,recordExceptionList);
	}

}
