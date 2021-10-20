package com.puneet.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadingFileByBufferedReaderVer2 implements ReadFileUtility {

	public void readFile(String choice) {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_INPUT_PATH)));
				FileWriter fw = new FileWriter(new File(FILE_OUTPUT_PATH + choice +"_cmdforRam.txt"))) {
			String word;
			while ((word=br.readLine())!= null) {
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
