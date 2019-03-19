package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

//@CucumberOptions(features = "src/test/resources/features/IOSApp.feature", glue = {
@CucumberOptions(features = "src/test/resources/features/AndroidApp.feature", glue = {
//@CucumberOptions(features = "src/test/resources/features/Login.feature", glue = {
		"stepDefinitions" }, tags = { "not (@inProgress or @manualTest or @todoDev)" }, plugin = { "pretty",
				"json:target/cucumber-reports/Cucumber.json",
				"html:target/cucumber-reports" }, monochrome = true, dryRun = false, strict = false)
public class testRunner extends AbstractTestNGCucumberTests {
	@AfterSuite
	public static void writeCucumberHtmlReport() {
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("./target/cucumber-reports/Cucumber.json");

		String buildNumber = "1";
		String projectName = "Appium Java";
		boolean runWithJenkins = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		@SuppressWarnings("unused")
		Reportable result = reportBuilder.generateReports();
	}

}
