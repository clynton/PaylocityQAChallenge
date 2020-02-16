package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class buttonClicker {

	public static String Click(WebDriver driver, By elementFinder) {
		return buttonClicker.Click(driver, elementFinder, 0);	
	}
	
	/*
	 * Returns empty string if all appears to have gone well. exception message if got an exception
	 */
	public static String Click(WebDriver driver, By elementFinder, int delayAfterClick_ms) {

		String result = "";
		
		try {
			driver.findElement(elementFinder).click();
		} catch (Exception ex) {
			//System.out.println(ex.getMessage());
			result = ex.getMessage();
			// e.printStackTrace();
		}

		// if need to wait after the click
		if (delayAfterClick_ms > 0) {
			try {
				Thread.sleep(delayAfterClick_ms);
			} catch (InterruptedException e) {
			} catch (Exception ex) {
			}
		}
		
		return result;
	}

}
