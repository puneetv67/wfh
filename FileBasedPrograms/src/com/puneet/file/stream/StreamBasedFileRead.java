package com.puneet.file.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.puneet.file.csv.Sports;

import com.puneet.file.ReadFileUtility;

public class StreamBasedFileRead implements ReadFileUtility {

	public static void main(String[] args) {
		try(Stream<String> lines = Files.lines(Paths.get(FILE_INPUT_PATH))){
			/*long count = lines.filter(a->a.startsWith("P")).count();
			System.out.println(" Count of words in file starting with P" + count);
			lines.count();*/
			//System.out.println(" Count of words in file " + lines.count());
			//lines.filter(a->a.startsWith("C"))
			lines.forEach(System.out::println);
			readFile();
			readFileviaPattern();
			readFileviaPattern();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFile() {
		try (Stream<String> lines = Files.lines(Paths.get(FILE_INPUT_PATH))) {
			  
			  Stream<String> words = lines
			    .flatMap(line -> Stream.of(line.split("\\W+")));
			  
			  Set<String> wordSet = words.collect(Collectors.toSet());

			  System.out.println(wordSet);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public <T> void printList(List<T> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readFile(String choice) {
	}
	public static void readFileviaPattern() {
		Pattern pattern = Pattern.compile(",");

		try (Stream<String> lines = Files.lines(Paths.get(CSV_FILE_INPUT_PATH))) {
		  List<Sports> sports = lines.skip(1).map(line -> {
		    String[] arr = pattern.split(line);
		    return new Sports(
		        arr[0], 
		        arr[1], 
		        arr[2]);
		  }).collect(Collectors.toList());

		  sports.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFilebySplit(String choice) {

		try (Stream<String> lines = Files.lines(Paths.get(CSV_FILE_INPUT_PATH))) {
			List<Sports> sports = lines.skip(1).map(line -> {
		  String[] arr = line.split(COMMA_DELIMITER);
		    return new Sports(
		        arr[0], 
		        arr[1], 
		        arr[2]);
		  }).collect(Collectors.toList());

		  sports.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
