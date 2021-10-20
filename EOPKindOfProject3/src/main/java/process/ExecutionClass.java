package main.java.process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

import main.java.properties.PropertyLoader;

public class ExecutionClass {

	PropertyLoader obj;
	private static Properties fileSytemProperties;
	private static Properties fileProperties;
	
	public static void main(String[] args) {
		try {
			fileSytemProperties = PropertyLoader.loadPerties(new File("D:\\JavaPrograms\\File\\cmp\\configproperties\\filesystem.properties"));
			fileProperties = PropertyLoader.loadPerties(new File("D:\\JavaPrograms\\File\\cmp\\configproperties\\" + args[0] +".properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CSVFileProcessor obj = new CSVFileProcessor();
		obj.fileReader(fileSytemProperties,fileProperties,args[0]);
	}

}
