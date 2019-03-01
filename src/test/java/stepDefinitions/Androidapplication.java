package stepDefinitions;

import java.util.HashMap;

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
import pages.WebView;
import utils.ReusableFunctions;

public class Androidapplication {

	private World world;
	private AppiumDriver<?> driver;
	private HashMap<String, String> map;
	APIDemo apidemoscreen;
	Preference preferencescreen;
	PreferenceDependencies preferencedependenciesscreen;
	Views viewsscreen;
	CustomAdapter customadapterscreen;
	ExpandableLists expandablelistsscreen;
	ReusableFunctions rfunctions;
	WebView webviewscreen;

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
		webviewscreen = new WebView(driver);
		rfunctions = new ReusableFunctions(driver);
		map = (HashMap<String, String>) world.context.get("config");
	}

	@Given("^I am on the WIFI settings screen$")
	public void i_am_on_the_wifi_settings_screen() {
		apidemoscreen.clickpreference();
		preferencescreen.clickpreferencedependencies();
		preferencedependenciesscreen.clickwificheckbox();
		preferencedependenciesscreen.clickwifisetting();
	}

	@When("^I try to update the WIFI settings$")
	public void i_try_to_update_the_wifi_settings_with_something() {
		preferencedependenciesscreen.enterwifisetting(map.get("WIFIValue"));
		preferencedependenciesscreen.savewifisetting();
	}

	@Then("^I am able to save it succesfully$")
	public void i_am_able_to_save_it_succesfully() {
		preferencedependenciesscreen.clickwifisetting();
		preferencedependenciesscreen.verifyWifiSetting(map.get("WIFIValue"));

		// value from app verify it with mapvalue
	}

	@Given("^I am on the Custom Adapter screen$")
	public void i_am_on_the_custom_adapter_screen() {
		apidemoscreen.tapviews();
		viewsscreen.clickexpandablelists();
		expandablelistsscreen.clickcustomadaptor();

	}

	@When("^I try to longpress the people name$")
	public void i_try_to_longpress_the_people_name() {
		customadapterscreen.longpresspeoplenames();
	}

	@Then("^I am able to see the options$")
	public void i_am_able_to_see_the_options() {
		rfunctions.clickmobilebackbutton();
		customadapterscreen.verifysamplemenu();
	}

	@Given("^I am on the View screen$")
	public void i_am_on_the_view_screen() {
		apidemoscreen.tapviews();
	}

	@When("^I try to open the WebView screen$")
	public void i_try_to_open_the_webview_screen() {
		viewsscreen.clickWebView();
	}

	@Then("^I am able to see the text on the page$")
	public void i_am_able_to_see_the_text_on_the_page() {
		webviewscreen.verifytext();
	}

}