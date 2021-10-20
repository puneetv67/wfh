package main.java.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	public PropertyLoader() {
	}

	public static Properties loadPerties(File propertyFile) throws FileNotFoundException {
		Properties prop = new Properties();
		try (FileReader reader = new FileReader(propertyFile)) {
			prop.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
