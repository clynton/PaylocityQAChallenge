package bddstepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.AssertJUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import utilities.EmployeeFeeCalculator;
import utilities.browserProvider;
import utilities.buttonClicker;
import utilities.configSettings;
import utilities.configSettings.Browser;
import utilities.configSettings.OtherUsefulFiles;
import utilities.logCollector;
import utilities.pageElementLocators;
import utilities.testData;
import utilities.testDataFromPropertyFile;

public class AddEmployeeNoDiscountSteps {

	WebDriver driver = null;
	private String firstNameUnderTest = "";
	private boolean firstNameUnderTestStartsWithA = false;
	private Integer dependentsUnderTest = 0;
	private String pageCalcBenefitsForEntryUnderTest;

	@Given("^S1 I am on the Benefits Dashboard page$")
	public void s1_i_am_on_the_benefits_dashboard_page() throws Throwable {
		logCollector.info("opening browser");

		driver = browserProvider.getBrowser(Browser.Chrome);

		// the driver should be goot to go
		Assert.assertNotEquals(null, driver);

		logCollector.info("going to home page in browser: " + driver.getClass().getName());

		// for some reason, get(page) is saying times out in ie - even though it works
		try {
			if (driver.getClass().getName() == configSettings.SeleniumClassNames.IE) {

				int pageLoadTimeoutForIE_s = configSettings.SeleniumBrowserDelayTimes.PageLoadTimeoutForIE_s;
				if (pageLoadTimeoutForIE_s > 0) {
					System.out.println(
							"setting page load timer for IE browser to " + pageLoadTimeoutForIE_s + " seconds...");
					driver.manage().timeouts().pageLoadTimeout(pageLoadTimeoutForIE_s, TimeUnit.SECONDS);
				}

				int delayBeforeLoadingUrlInIE_s = configSettings.SeleniumBrowserDelayTimes.DelayBeforeLoadingUrlInIE_s;
				if (delayBeforeLoadingUrlInIE_s > 0) {
					System.out.println("about to load page in IE browser... waiting " + delayBeforeLoadingUrlInIE_s
							+ " seconds...");

					try {
						// System.out.println("sleeping in");
						Thread.sleep(delayBeforeLoadingUrlInIE_s * 1000);
					} catch (InterruptedException e) {
						// e.printStackTrace();
						System.out.println(e.getMessage());
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}

			String mainPageUrl = testDataFromPropertyFile
					.getPropertyVal(testData.EmployeeAdminPage.UrlPropertyNameInDataFile);
			if (mainPageUrl == null || mainPageUrl == "") {
				Assert.fail("Property '" + testData.EmployeeAdminPage.UrlPropertyNameInDataFile
						+ "' apparently missing from Property File: '" + OtherUsefulFiles.TestDataPropertyFile + "'");
			}

			logCollector.debug("Loading page: " + mainPageUrl);

			driver.get(mainPageUrl);

		} catch (Exception ex) {
			// System.out.println(ex);

			// org.openqa.selenium.TimeoutException: Timed out waiting for page to load.
			// Build info: version: '3.141.59', revision: 'e82be7d358', time:
			// '2018-11-14T08:25:48'
			// System info: host: '...', ip: '...', os.name: 'Windows 10', os.arch: 'amd64',
			// os.version: '10.0', java.version: '13.0.1'
			// Driver info: org.openqa.selenium.ie.InternetExplorerDriver
			// Capabilities {acceptInsecureCerts: false, browserName: internet explorer,
			// browserVersion: 11, javascriptEnabled: true, pageLoadStrategy: normal,
			// platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), se:ieOptions:
			// {browserAttachTimeout: 0, elementScrollBehavior: 0, enablePersistentHover:
			// true, ie.browserCommandLineSwitches: , ie.edgechromium: false, ie.edgepath: ,
			// ie.ensureCleanSession: false, ie.fileUploadDialogTimeout: 3000,
			// ie.forceCreateProcessApi: false, ignoreProtectedModeSettings: false,
			// ignoreZoomSetting: false, initialBrowserUrl: http://localhost:40789/,
			// nativeEvents: true, requireWindowFocus: false}, setWindowRect: true,
			// strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000,
			// script: 30000}, unhandledPromptBehavior: dismiss and notify}

			// continue anyway
		}

		// in some browsers, might need Thread.sleep after loading the URL before
		// By.xpath and By.cssSelector work
		int delayAfterLoadingUrl_s = configSettings.SeleniumBrowserDelayTimes.DelayAfterLoadingUrl_s;
		if (delayAfterLoadingUrl_s > 0) {
			System.out.println("just loaded page... waiting " + delayAfterLoadingUrl_s + " seconds...");

			try {
				// System.out.println("sleeping in");
				Thread.sleep(delayAfterLoadingUrl_s * 1000);
			} catch (InterruptedException e) {
				// e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		// check that we got to the page...
		String expectedTitle = testData.EmployeeAdminPage.Title;
		String actualTitle = driver.getTitle();

		logCollector.debug("Loaded page - got title: '" + actualTitle + "'");
	
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@When("^S1 I select Add Employee$")
	public void s1_i_select_add_employee() throws Throwable {
		// Click a button - found using xpath or css or whatever
		// returns exception message if not there, but we can check for something else
		String clickResult = buttonClicker.Click(driver, pageElementLocators.EmployeeAdminPage.AddEmployeeBtn,
				configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);
		Assert.assertEquals("", clickResult);
	}

	@Then("^S1 I should be able to enter employee details$")
	public void s1_i_should_be_able_to_enter_employee_details() throws Throwable {

		// enter employee data
		// asserts for missing fields will occur automatically

		// text values
		driver.findElement(pageElementLocators.EmployeeAdminPage.FirstNameField)
				.sendKeys(testData.EmployeeAdminPage.PageTextFields.FirstName);
		driver.findElement(pageElementLocators.EmployeeAdminPage.LastNameField)
				.sendKeys(testData.EmployeeAdminPage.PageTextFields.LastName);
		driver.findElement(pageElementLocators.EmployeeAdminPage.DependentsField)
				.sendKeys("" + testData.EmployeeAdminPage.PageTextFields.Dependents);
	}

	@And("^S1 the employee should save$")
	public void s1_the_employee_should_save() throws Throwable {

		// submit - get the button element and make sure it's the right one...
		WebElement employeeSubmitBtn = driver.findElement(pageElementLocators.EmployeeAdminPage.SubmitEmployeeBtn);
		String buttonText = employeeSubmitBtn.getText();
		Assert.assertEquals(testData.EmployeeAdminPage.PageTextFields.SubmitEmployeeBtnText, buttonText);

		// ok - it's the right button, so go for it...

		// returns exception message if not there, but we can check for something else
		String clickResult = buttonClicker.Click(driver, pageElementLocators.EmployeeAdminPage.SubmitEmployeeBtn,
				configSettings.SeleniumBrowserDelayTimes.DelayAfterClickButton_ms);
		Assert.assertEquals("", clickResult);

	}

	@And("^S1 I should see the employee in the table$")
	public void s1_i_should_see_the_employee_in_the_table() throws Throwable {

		// search for the new entry in the DB

		List<WebElement> employeesList = driver.findElements(pageElementLocators.EmployeeAdminPage.EmployeeTableRows);

		boolean foundInsertedEntry = false;
		int numEmployeeEntries = employeesList.size();
		logCollector.debug("found " + numEmployeeEntries + " employee records (rows) to review");
		for (int ix = 0; ix < numEmployeeEntries; ix++) {
			WebElement elememployeeRow = employeesList.get(ix);

			logCollector.debug("row " + ix + " has: " + elememployeeRow.getText());
			
			WebElement firstNameEntry = elememployeeRow
					.findElement(pageElementLocators.EmployeeAdminPage.EmployeeRowColFirstName);
			WebElement lastNameEntry = elememployeeRow
					.findElement(pageElementLocators.EmployeeAdminPage.EmployeeRowColLastName);
			WebElement dependentsEntry = elememployeeRow
					.findElement(pageElementLocators.EmployeeAdminPage.EmployeeRowColDependents);
			WebElement benefitsCostEntry = elememployeeRow
					.findElement(pageElementLocators.EmployeeAdminPage.EmployeeRowColBenefitsCost);

			String rowFirstNameVal = firstNameEntry.getText();
			String rowLastNameVal = lastNameEntry.getText();
			Integer dependentsVal = Integer.parseInt(dependentsEntry.getText());
			String benefitsCostVal = benefitsCostEntry.getText();

			logCollector.debug("Looking at entry: '" + rowFirstNameVal + "' '" + rowLastNameVal + 
					"' '" + dependentsVal + "' with result '" + benefitsCostVal + "'");
			logCollector.debug("Comparing values: '" +  testData.EmployeeAdminPage.PageTextFields.FirstName + "' '" + 
					testData.EmployeeAdminPage.PageTextFields.LastName + "' '" + 
					testData.EmployeeAdminPage.PageTextFields.Dependents + "'");

			if (rowFirstNameVal.compareTo(testData.EmployeeAdminPage.PageTextFields.FirstName) == 0
					&& rowLastNameVal.compareTo(testData.EmployeeAdminPage.PageTextFields.LastName) == 0
					&& dependentsVal.compareTo(testData.EmployeeAdminPage.PageTextFields.Dependents) == 0) {
				
				logCollector.debug("Found the match!");
				foundInsertedEntry = true;
				firstNameUnderTest = rowFirstNameVal;
				dependentsUnderTest = dependentsVal;
				pageCalcBenefitsForEntryUnderTest = benefitsCostVal;

				break;
			} else {
				logCollector.debug("No match: '" +  (rowFirstNameVal.compareTo(testData.EmployeeAdminPage.PageTextFields.FirstName) == 0) + "' '" + 
						(rowLastNameVal.compareTo(testData.EmployeeAdminPage.PageTextFields.LastName) == 0) + "' '" + 
						(dependentsVal.compareTo(testData.EmployeeAdminPage.PageTextFields.Dependents) == 0) + "'");
			}
		}

		Assert.assertTrue(foundInsertedEntry);
	}

	@And("^S1 First Name does not begin with “A” or “a”$")
	public void s1_first_name_does_not_begin_with_a_or_a() throws Throwable {

		// grab value and set bool - could also get it in the cost validator
		firstNameUnderTestStartsWithA = (firstNameUnderTest.compareToIgnoreCase("A") == 0); // 0 == same
	}

	@And("^S1 the benefit cost calculations are correct$")
	public void s1_the_benefit_cost_calculations_are_correct() throws Throwable {

		// check the cost values

		// we can do some white-box testing of our own code here by calling
		// "CalculateFee(1, true -and- false)"

		// if name starts with A, they get a 10% discount
		// this call is not explicitly needed, but good to check our own calc
		double amountForEmployeeWithDiscount = EmployeeFeeCalculator
				.CalculateFee(testData.EmployeeAdminPage.PageTextFields.Dependents, firstNameUnderTestStartsWithA);

		// send either one of these next, because we've already checked that
		// firstNameUnderTest == testData.EmployeeAdminPage.PageTextFields.FirstName
		double amountForThisEmployee = EmployeeFeeCalculator.CalculateFee(firstNameUnderTest, dependentsUnderTest);

		logCollector.debug("Comparing Costs - 'A' employees: '" + amountForEmployeeWithDiscount + "' / This employee: '"
				+ String.valueOf(amountForThisEmployee) + "' / Page value for employee: '" + pageCalcBenefitsForEntryUnderTest + "'");

		Assert.assertEquals(String.valueOf(amountForThisEmployee), pageCalcBenefitsForEntryUnderTest);

		logCollector.debug("All done - closing Browser(s)... ");
		browserProvider.closeBrowsers();
	}

}
