package com.puneet.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadingAFileUsingScanner {

	private static Scanner scanFile;
	private static FileWriter fw;

	public void readFile(File inputFile, File outputFile) {

		try {
			scanFile = new Scanner(inputFile);
			fw = new FileWriter(outputFile);
			while (scanFile.hasNextLine()) {
				fw.append(scanFile.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (scanFile != null)
					scanFile.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		ReadingAFileUsingScanner readWriteFile = new ReadingAFileUsingScanner();
		scanFile = new Scanner(System.in);
		System.out.println(" Enter the complete filepath");
		String filePath = scanFile.next();
		File inputFile = new File(filePath);
		final String DELIMITER = "\\";
		String outputFileName = "output_" + filePath.substring(filePath.lastIndexOf(DELIMITER) + 1, filePath.length());
		File outputFile = new File("D:\\JavaPrograms\\File\\output\\" + outputFileName);
		System.out.println(outputFileName);
		readWriteFile.readFile(inputFile, outputFile);
	}

}
