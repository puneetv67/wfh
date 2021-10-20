package com.puneet.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingFileByBufferedReader {
	
	private static BufferedReader bfr;
	private static FileWriter fw;
	public static void main(String[] args) {
		
		try {
			File file = new File("D:\\JavaPrograms\\File\\txt\\cmdforRam.txt");
			bfr = new BufferedReader(new FileReader(file));
			String outputFileName = "br_output_" + file.getName();
			File outputFile = new File("D:\\JavaPrograms\\File\\output\\" + outputFileName);
			readAndWriteFile(bfr, outputFile);
		} 
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(bfr!=null)
				bfr.close();
				if(fw!=null)
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void readAndWriteFile(BufferedReader bfr, File outputFile) throws IOException{
			String st;
			fw = new FileWriter(outputFile);
			while ((st = bfr.readLine() )!= null) {
				fw.append(st);
			}
			fw.append("abcbcbcb");
	}
}
