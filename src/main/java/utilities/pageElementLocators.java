package utilities;

import org.openqa.selenium.By;

public class pageElementLocators {

	public static class EmployeeAdminPage {

		public static final By AddEmployeeBtn = By.id(pageElementSelectors.EmployeeAdminPage.AddEmployeeBtnIdSelector);

		public static final By FirstNameField = By.cssSelector(pageElementSelectors.EmployeeAdminPage.FirstNameCssPathSelector);
		public static final By LastNameField = By.cssSelector(pageElementSelectors.EmployeeAdminPage.LastNameCssPathSelector);
		public static final By DependentsField = By.cssSelector(pageElementSelectors.EmployeeAdminPage.DependentsCssPathSelector);

		public static final By SubmitEmployeeBtn = By.cssSelector(pageElementSelectors.EmployeeAdminPage.SubmitEmployeeBtnCssSelector);

		public static final By EmployeeTableRows = By.cssSelector(pageElementSelectors.EmployeeAdminPage.EmployeeTableRowsCssSelector);
		public static final By EmployeeRowColFirstName = By.cssSelector(pageElementSelectors.EmployeeAdminPage.EmployeeRowColFirstNameCssSelector);
		public static final By EmployeeRowColLastName = By.cssSelector(pageElementSelectors.EmployeeAdminPage.LastNameCssPathSelector);
		public static final By EmployeeRowColDependents = By.cssSelector(pageElementSelectors.EmployeeAdminPage.EmployeeRowColDependentsCssSelector);
		public static final By EmployeeRowColBenefitsCost = By.cssSelector(pageElementSelectors.EmployeeAdminPage.EmployeeRowColBenefitsCostCssSelector);
		
	}


}
