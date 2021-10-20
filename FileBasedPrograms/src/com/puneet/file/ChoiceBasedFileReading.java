package com.puneet.file;

import java.util.Scanner;

import com.puneet.file.csv.CSVFileRead;

public class ChoiceBasedFileReading {

	static int counter=0;
	public static void main(String[] args) {

		System.out.println(" Enter the choice: 1 - Reading file by Scanner\n" + "2 - Reading file by BufferedReader\n"
				+ "3 - Reading file by FileReader\n" + "4 - Reading files by Files.readAllLines\n"
				+ "5 - CSV file read\n");
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				int choice = scanner.nextInt();
				choiceBasedFileReading(choice);
			}
		}
	}

	public static void choiceBasedFileReading(int choice) {
		
		switch (choice) {
		case 1:
			ReadingFileUsingScannerVer2 rfus = new ReadingFileUsingScannerVer2();
			rfus.readFile("scanner");
			break;
		case 2:
			ReadingFileByBufferedReaderVer2 rfbr = new ReadingFileByBufferedReaderVer2();
			rfbr.readFile("br");
			break;
		case 3:
			ReadingFileByFileReaderVer2 rffr = new ReadingFileByFileReaderVer2();
			rffr.readFile("fr");
			break;
		case 4:
			ReadingFileIntoListVer2 rfil = new ReadingFileIntoListVer2();
			rfil.readFile("fl");
			break;
		case 5:
			CSVFileRead csvfr = new CSVFileRead();
			csvfr.readFile("csv");
			break;
		default:
			
			counter++;
			if(counter>2){
				System.out.println("Existing program: all turns exhausted");
				System.exit(1);
			}
			System.out.println(" Please enter correct choice");
		}
	}

}
