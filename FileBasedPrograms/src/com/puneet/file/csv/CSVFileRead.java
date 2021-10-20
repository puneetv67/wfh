package com.puneet.file.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.puneet.file.ReadFileUtility;

public class CSVFileRead implements ReadFileUtility{

	@Override
	public void readFile(String choice) {
		try(BufferedReader br = new BufferedReader(new FileReader(new File(CSV_FILE_INPUT_PATH)))){
			List<Sports> sportList = new ArrayList<>();
			String content = br.readLine();
			while((content=br.readLine())!=null && !content.isEmpty()){
				String[] fields = content.split(COMMA_DELIMITER);
				Sports obj = new Sports(fields[0],fields[1],fields[2]);
				sportList.add(obj);
			}
			if(sportList!=null && !sportList.isEmpty()){
				printList(sportList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("hiding")
	@Override
	public <Sports> void printList(List<Sports> tList) {
		for(Sports obj : tList){
			//obj.toString();
			System.out.println(obj);
			System.out.println(obj.toString());
		}
	}



}
