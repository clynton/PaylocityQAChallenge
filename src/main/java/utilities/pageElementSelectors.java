package utilities;

public class pageElementSelectors {

	public static class EmployeeAdminPage {

		public static final String AddEmployeeBtnIdSelector = "btnAddEmployee";

		// could also use: label[for='firstname']+div[class='col-sm-10']>input[type='text']
		public static final String FirstNameCssPathSelector = "label[for='firstname']+div>input";

		public static final String LastNameCssPathSelector = "label[for='lastname']+div>input";

		public static final String DependentsCssPathSelector = "label[for='dependents']+div>input";

		// best to add an ID for the button - or a name... but for now, we'll just check the text value to confirm
		// could also have gone to the dependents field and tabbed to it (but more fields might be added)
		public static final String SubmitEmployeeBtnCssSelector = "#employees-form button.btn-primary";

		public static final String EmployeeTableRowsCssSelector = "#employee-table > tbody:nth-child(2) > tr";
		public static final String EmployeeRowColFirstNameCssSelector = "td:nth-child(2)";
		public static final String EmployeeRowColLastNameCssSelector = "td:nth-child(3)";
		public static final String EmployeeRowColDependentsCssSelector = "td:nth-child(5)";
		public static final String EmployeeRowColBenefitsCostCssSelector = "td:nth-child(7)";
	}

}
