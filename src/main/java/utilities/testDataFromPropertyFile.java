package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import utilities.configSettings.OtherUsefulFiles;

public class testDataFromPropertyFile {

	static Properties loadedProps = null;

	public static String getPropertyVal(String prop) {
		if (loadedProps == null) {
			// load property file now
			FileInputStream stream;
			try {
				stream = new FileInputStream(OtherUsefulFiles.TestDataPropertyFile);
				loadedProps = new Properties();
				loadedProps.load(stream);
			} catch (FileNotFoundException e1) {
				//e1.printStackTrace();
				logCollector.debug("Unable to find/load Test Data Property File: " + OtherUsefulFiles.TestDataPropertyFile);
			} catch (IOException e) {
				//e.printStackTrace();
				logCollector.debug("Unable to load properties from Data Property File: " + OtherUsefulFiles.TestDataPropertyFile);
			}
		}

		if (loadedProps != null)
		{
			return loadedProps.getProperty(prop);
		}
		
		return "";
	}

}
