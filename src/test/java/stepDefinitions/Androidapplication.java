package stepDefinitions;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.APIDemo;
import pages.Preference;
import pages.PreferenceDependencies;

public class Androidapplication {

	private World world;
	private AppiumDriver<WebElement> driver;
	APIDemo apidemoscreen;
	Preference preferencescreen;
	PreferenceDependencies preferencedependenciesscreen;

	@SuppressWarnings("unchecked")
	public Androidapplication(World world) {
		this.world = world;
		driver = (AppiumDriver<WebElement>) this.world.context.get("driver");
		apidemoscreen = new APIDemo(driver);
		preferencescreen = new Preference(driver);
		preferencedependenciesscreen = new PreferenceDependencies(driver);
	}

	@Given("^I am on the WIFI settings screen$")
	public void i_am_on_the_wifi_settings_screen() throws Throwable {
		apidemoscreen.clickpreference();
		preferencescreen.clickpreferencedependencies();
		preferencedependenciesscreen.clickwificheckbox();
		preferencedependenciesscreen.clickwifisetting();
	}

	@When("^I try to update the WIFI settings$")
	public void i_try_to_update_the_wifi_settings_with_something() {
		preferencedependenciesscreen.enterwifisetting("Value");
		preferencedependenciesscreen.savewifisetting();
	}

	@Then("^I am able to save it succesfully$")
	public void i_am_able_to_save_it_succesfully() throws Throwable {
	}

}