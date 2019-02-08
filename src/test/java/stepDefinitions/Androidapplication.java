package stepDefinitions;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.APIDemo;
import pages.CustomAdapter;
import pages.ExpandableLists;
import pages.Preference;
import pages.PreferenceDependencies;
import pages.Views;
import utils.ReusableFunctions;

public class Androidapplication {

	private World world;
	private AppiumDriver<WebElement> driver;
	APIDemo apidemoscreen;
	Preference preferencescreen;
	PreferenceDependencies preferencedependenciesscreen;
	Views viewsscreen;
	CustomAdapter customadapterscreen;
	ExpandableLists expandablelistsscreen;
	ReusableFunctions rfunctions;

	@SuppressWarnings("unchecked")
	public Androidapplication(World world) {
		this.world = world;
		driver = (AppiumDriver<WebElement>) this.world.context.get("driver");
		apidemoscreen = new APIDemo(driver);
		preferencescreen = new Preference(driver);
		preferencedependenciesscreen = new PreferenceDependencies(driver);
		customadapterscreen = new CustomAdapter(driver);
		expandablelistsscreen = new ExpandableLists(driver);
		viewsscreen = new Views(driver);
		rfunctions = new ReusableFunctions(driver);
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

	@Given("^I am on the Custom Adapter screen$")
	public void i_am_on_the_custom_adapter_screen() throws Throwable {
		apidemoscreen.tapviews();
		viewsscreen.clickexpandablelists();
		expandablelistsscreen.clickcustomadaptor();

	}

	@When("^I try to longpress the people name$")
	public void i_try_to_longpress_the_people_name() throws Throwable {
		customadapterscreen.longpresspeoplenames();
	}

	@Then("^I am able to see the options$")
	public void i_am_able_to_see_the_options() throws Throwable {
		rfunctions.clickmobilebackbutton();
		customadapterscreen.verifysamplemenu();
	}

}