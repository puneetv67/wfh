package com.puneet.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadingFileByFileReaderVer2 implements ReadFileUtility {

	public void readFile(String choice) {
		try (FileReader fr = new FileReader(new File(FILE_INPUT_PATH));
				FileWriter fw = new FileWriter(new File(FILE_OUTPUT_PATH+choice+"_cmdforRam.txt"))) {
			int counter;
			while ((counter = fr.read()) != -1) {
				fw.append((char) counter);
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
