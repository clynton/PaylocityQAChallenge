package bddtestrunners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// manually add "import cucumber.api.junit.Cucumber;" for "Cucumber.class" below

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\bddfeatures", glue = { "bddstepdefinitions" },

		plugin = { "pretty", "html:target/htmlreports",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },

		monochrome = true, // display the console output in a proper readable format
		strict = true, // it will check if any step is not defined in step definition file
		dryRun = false, // to check the mapping is proper between feature file and step def file
				//		tags = { "@regressiontest" }
		tags = { "@paylocitytest" }
//		tags = { "@smoketest, @regressiontest" }
)
public class bddRunnerTest {
	// NOTE: Class must start/end with case sensitive "Test"
	// https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#includes
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
}
