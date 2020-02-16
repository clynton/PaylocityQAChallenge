package utilities;

public class configSettings {

	public static enum Browser {
		Chrome, FireFox, IE
	}

	public class SeleniumBrowserDelayTimes {
		public static final int DelayBeforeReturningBrowser_ms = 100;
		public static final long DelayWaitingForPageElems_s = 20;
		public static final long DelayWaitingForPageLoad_s = 30;
		public static final int DelayBeforeCloseBrowsers_s = 10;
		public static final int DelayBeforeLoadingUrlInIE_s = 3;
		public static final int DelayAfterLoadingUrl_s = 2;
		public static final int PageLoadTimeoutForIE_s = 5;
		public static final int DelayAfterClickButton_ms = 2000;
	}

	public class SeleniumDriverPropNames {

		public static final String Chrome = "webdriver.chrome.driver";
		public static final String IE = "webdriver.ie.driver";
		public static final String FireFox = "webdriver.gecko.driver";
	}

	public class SeleniumDriverPaths {

		public static final String Chrome = "C:\\selenium\\drivers\\chromedriver.exe";
		public static final String IE = "C:\\selenium\\drivers\\IEDriverServer.exe";
		public static final String FireFox = "C:\\selenium\\drivers\\geckodriver.exe";
	}
	
	public class SeleniumClassNames {

		public static final String IE = "org.openqa.selenium.ie.InternetExplorerDriver";
	}
	
	public class OtherUsefulFiles {

		public static final String TestDataPropertyFile = "config\\testDataProps.properties";
	}
	
	
}
