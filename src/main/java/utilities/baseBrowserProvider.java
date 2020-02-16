package utilities;

import java.util.Hashtable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilities.configSettings.Browser;

abstract class baseBrowserProvider {

	static Hashtable<Browser, WebDriver> loadedWebDrivers = new Hashtable<Browser, WebDriver>();

	/**
	 * Get a WebDriver
	 * 
	 * @param browser
	 * @return
	 */
	public static WebDriver get(Browser browser) {

		System.out.println("caller wants the '" + browser + "' web browser driver...");

		WebDriver driverToReturn = loadedWebDrivers.get(browser);

		if (driverToReturn == null) { // if not there, load it up...

			switch (browser) {
			
			case Chrome:
				System.setProperty(configSettings.SeleniumDriverPropNames.Chrome,
						configSettings.SeleniumDriverPaths.Chrome);
				loadedWebDrivers.put(browser, new ChromeDriver());
				break;

			case IE:
				System.setProperty(configSettings.SeleniumDriverPropNames.IE, configSettings.SeleniumDriverPaths.IE);
				loadedWebDrivers.put(browser, new InternetExplorerDriver());
				break;

			default: // since we use an enum and not a string this is the same as 'case FireFox:'
				System.setProperty(configSettings.SeleniumDriverPropNames.FireFox,
						configSettings.SeleniumDriverPaths.FireFox);
				loadedWebDrivers.put(browser, new FirefoxDriver());
				break;
			}
		}

		return loadedWebDrivers.get(browser); // get the same/new driver

	}
}
