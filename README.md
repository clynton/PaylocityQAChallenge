# Paylocity Review

# Questions
* Is it OK to assume we are on the admin (home) page or should we start on the login page and submit login credentials? (dictates whether we need a login scenario)

# TODO
* Write up 3 test cases (1 for each BDD test scenario) - formal test docs
- setup a bug report template doc

# BUGS
1. Any username gets you to the admin page if set directly in the url
    (only in the login-page form does it validate - or when no value is given in the query string)
2. Clicking on the labels do not switch the focus to the corresponding input boxes 
    (they have a 'for' attribute but the input fields do not have id attributes)
3. The ID column value in the table is always 1
4. The Dependents field accepts text strings (and inserts the record with NaN calculated values)
5. The 'X' button does not delete the elements
6. The same employee entry is allowed - full name and dependents being exact matches - both for 'add' and 'edit'
7. Large numbers are accepted for dependent value (ex: 4000)
8. Negative numbers are accepted for dependent values (ex: -20)

* (FAD) The keywords being written in upper case is right for the user story, but needs to be sentence case in the feature file. Also, set a scenario # as a best practice to prevent collissions.
- https://cucumber.io/blog/bdd/getting-started-with-bdd-part-1/



# Pistold
Platform for Internet Site Testing Over Long Distances
- A simple automation test project - using Selenium - built using Maven
- The sample connects to GitHub in Chrome/Firefox/IE web Driver(s) and clicks a link
- has examples of using Data Driven and Behavior Driven Testing frameworks

# PreReq
* Requires git, maven, selenium (Jar files and webdriver EXEs), JDK (1.8 or greater)
* For the IDE, we can use Eclipse, VS Studio Code, etc

# Install

* Clone/download this repo

```shell
git clone https://github.com/clynton/Pistold.git MyAutomationTestr
```

# Setup
	
1. If using eclipse: Import Project > Maven > Existing Maven Project
2. Change the values of 'groupId' and 'artifactId' in pom.xml
3. Update the project after changing the POM: Right-Click project > Maven > Update Project
4. Right-Click project > Properties > Libraries
5. Edit the JDK/JRE setting if required: (or Add Library > JRE System Library > select one)
6. Change the paths to the log files in log4j.properties
7. Change the paths for SeleniumDriverPaths in configSettings.java

# Try It
1. Right-Click loadHomepageInDiffBrowsers.java > Run as TestNG Test
2. Right-Click bddRunnerTest.java > Run as JUnit Test
3. Run our tests using maven (can be done in a bat file - using 'call mvn test' if so)

```dos
cd MyAutomationTestr
mvn test
```

# Validation

1. The Console/Output might show some warnings, but there shouldn't be any major errors
2. Errors might result from missing/outdated Jar/Lib files, bad path or config values, etc
3. Check that there's stuff in app.log after the test run
4. Check files under target like htmlreports/index.html and cucumber-reports/report.html

# Next Steps

1. Change the url and title page in testData.java
2. Remove extra things if desired - ex: testDataFromPropertyFile
3. Add test case classes similar to loadHomepageInDiffBrowsers.java
4. Use the batch file in jenkins, windows task manager, etc

# TO DO
- maybe use POI to pull test data from Excel files - keyword driven framework
- maybe setup a Selenium Grid environment - having a local hub and nodes... 

<br/><br/><br/>



