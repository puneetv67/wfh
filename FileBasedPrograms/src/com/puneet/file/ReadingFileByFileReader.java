package com.puneet.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingFileByFileReader {

	private static FileWriter fw;
	private static FileReader fr;

	public static void main(String[] args) {
		File file = new File("D:\\JavaPrograms\\File\\txt\\cmdforRam.txt");
		String outputFileName = "fr_output_" + file.getName();
		File outputFile = new File("D:\\JavaPrograms\\File\\output\\" + outputFileName);
		try {
			fr = new FileReader(file);
			readAndWriteFile(fr, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void readAndWriteFile(FileReader fr, File outputFile) throws IOException {
		fw = new FileWriter(outputFile);
		int i;
		while ((i = fr.read()) != -1) {
			System.out.println((char) i);
			fw.append((char) i);
		}
	}
}
