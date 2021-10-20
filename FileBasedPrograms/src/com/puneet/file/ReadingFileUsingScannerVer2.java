package com.puneet.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReadingFileUsingScannerVer2 implements ReadFileUtility {

	public void readFile(String choice) {
		File inputFile = new File(FILE_INPUT_PATH);
		File outputFile = new File(FILE_OUTPUT_PATH + choice + "_cmdforRam.txt");
		try (Scanner scanner = new Scanner(inputFile); FileWriter fw = new FileWriter(outputFile)) {
			while (scanner.hasNext()) {
				fw.append(scanner.next());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void printList(List<T> t) {
		// TODO Auto-generated method stub
		
	}
}
