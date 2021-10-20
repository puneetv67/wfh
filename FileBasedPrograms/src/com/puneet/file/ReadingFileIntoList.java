package com.puneet.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReadingFileIntoList {


	public static void main(String[] args) {
		File file = new File("D:\\JavaPrograms\\File\\txt\\cmdforRam.txt");
		String outputFileName = "fl_output_" + file.getName();
		File outputFile = new File("D:\\JavaPrograms\\File\\output\\" + outputFileName);
		readFileIntoList(file.getAbsolutePath(), outputFile);

	}

	public static void readFileIntoList(String fileName, File outputFile) {
		if (fileName != null && !fileName.isEmpty()) {
			List<String> fileIntoList = Collections.emptyList();
			try {
				fileIntoList = Files.readAllLines(Paths.get(fileName));
				readAndWriteFile(fileIntoList, outputFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void readAndWriteFile(List<String> fileList, File outputFile) throws IOException {
		try(FileWriter fw = new FileWriter(outputFile)) {
		if (!fileList.isEmpty()) {
			for (String word : fileList) {
				fw.append(word);
			}
		}
	}
}
}
