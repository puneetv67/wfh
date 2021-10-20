package com.puneet.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReadingFileIntoListVer2 implements ReadFileUtility {

	public void readFile(String choice) {
		List<String> fileIntoList = Collections.emptyList();
		try (FileWriter fw = new FileWriter(new File(FILE_OUTPUT_PATH+choice+"_cmdforRam.txt"))) {
			fileIntoList = Files.readAllLines(Paths.get(FILE_INPUT_PATH));
			for (String word : fileIntoList) {
				fw.append(word);
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
