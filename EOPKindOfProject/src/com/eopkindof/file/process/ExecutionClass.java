package com.eopkindof.file.process;

public class ExecutionClass {

	public static void main(String[] args) {
		CSVFileProcessor obj = new CSVFileProcessor();
		obj.fileReader(args[0]);
	}

}
