package utilities;

import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import utilities.configSettings.Browser;

public class browserProvider extends baseBrowserProvider {

	public static WebDriver getBrowser(Browser browser) {

		WebDriver driverToReturn = loadedWebDrivers.get(browser);

		Boolean returningNewDriver = false;

		// if it's not there already, we'll launch it and maximize it...
		if (driverToReturn == null) {
			driverToReturn = get(browser);

			if (driverToReturn != null) { // just loaded

				returningNewDriver = true;

				// always set these now... don't wait for a main suite setup class,
				// because might be running single test cases
				driverToReturn.manage().window().maximize();
				driverToReturn.manage().deleteAllCookies();
				driverToReturn.manage().timeouts().pageLoadTimeout(
						configSettings.SeleniumBrowserDelayTimes.DelayWaitingForPageLoad_s, TimeUnit.SECONDS);
				// waits for page elements
				driverToReturn.manage().timeouts().implicitlyWait(
						configSettings.SeleniumBrowserDelayTimes.DelayWaitingForPageElems_s, TimeUnit.SECONDS);

				// only wait if we just launched a new browser... and delay value is > 0
				int delayBeforeReturningBrowser_ms = configSettings.SeleniumBrowserDelayTimes.DelayBeforeReturningBrowser_ms;
				System.out.println("after launching browser... waiting " + delayBeforeReturningBrowser_ms
						+ " seconds before returning...");
				if (delayBeforeReturningBrowser_ms > 0) {
					try {
						// System.out.println("sleeping in");
						Thread.sleep(delayBeforeReturningBrowser_ms);
					} catch (InterruptedException e) {
						// e.printStackTrace();
						System.out.println(e.getMessage());
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}

		}

		if (driverToReturn == null) {
			// could throw an exception instead
			System.out.println("This might be important... We don't have a driver to return...");
		} else {

			try {
				System.out.println("returning " + ((returningNewDriver) ? "new" : "existing") + " driver: "
						+ driverToReturn.getClass().getTypeName());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				try {
					System.out.println("... returning " + ((returningNewDriver) ? "new" : "existing") + " driver: "
							+ driverToReturn.toString());
				} catch (Exception ex2) {
					System.out.println(ex2.getMessage());
					try {
						System.out.println("!!! returning " + ((returningNewDriver) ? "new" : "existing")
								+ " driver: <can't get name - is it null? > ");
					} catch (Exception ex3) {
						System.out.println(ex3.getMessage());
					}
				}
			}
		}

		return driverToReturn;
	}

	public static void closeBrowsers() {
		int delayBeforeCloseBrowsers_s = configSettings.SeleniumBrowserDelayTimes.DelayBeforeCloseBrowsers_s;
		System.out.println("about to close browsers... waiting " + delayBeforeCloseBrowsers_s + " seconds...");

		try {
			// System.out.println("sleeping in");
			Thread.sleep(delayBeforeCloseBrowsers_s * 1000);
		} catch (InterruptedException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		Enumeration<Browser> enumer = loadedWebDrivers.keys();
		while (enumer.hasMoreElements()) {
			Browser browser = enumer.nextElement();
			WebDriver driverToClose = loadedWebDrivers.get(browser);
			if (driverToClose != null) {

				System.out.println("Quitting Browser: " + driverToClose.toString());
				driverToClose.quit();

			}
		}
		loadedWebDrivers.clear(); // in case they want to call again
	}
}
