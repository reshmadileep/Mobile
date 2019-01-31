package runner;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features = "src/test/java/features/",
        glue = { "stepDefinitions" },
        tags= {"not (@inProgress or @manualTest or @todoDev)"},
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"html:target/cucumber-reports" },
        monochrome = false,
        dryRun = false,
        strict = false)
public class testRunner extends AbstractTestNGCucumberTests {

}
