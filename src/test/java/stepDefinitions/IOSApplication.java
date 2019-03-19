package stepDefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.IOSAlertViewScreen;
import pages.IOSSwitchesScreen;
import pages.IOSUICatalogScreen;
import utils.ReusableFunctions;

public class IOSApplication {

	private World world;
	private AppiumDriver<?> driver;
	private HashMap<String, String> map;
	IOSUICatalogScreen uicataloghomescreen;
	IOSAlertViewScreen alertscreen;
	IOSSwitchesScreen switchsscreen;
	ReusableFunctions rfunctions;

	@SuppressWarnings("unchecked")
	public IOSApplication(World world) {
		this.world = world;
		driver = (AppiumDriver<WebElement>) this.world.context.get("driver");
		rfunctions = new ReusableFunctions(driver);
		map = (HashMap<String, String>) world.context.get("config");
		alertscreen = new IOSAlertViewScreen(driver);
		uicataloghomescreen = new IOSUICatalogScreen(driver);
		switchsscreen = new IOSSwitchesScreen(driver);

	}

	@Given("I am on the Alert Views Screen")
	public void I_am_on_the_Alert_Views_Screen() {
		uicataloghomescreen.clickalertviews();
	}

	@When("I try to save short title")
	public void I_try_to_save_short_title() {
		alertscreen.clicktextentry();
		alertscreen.entershorttitle(map.get("ShortTitle"));

	}
	
	@When("I try to scroll down to see toggle text")
	public void I_try_to_scroll_down_to_see_toggle_text() {
		uicataloghomescreen.clickswitches();
	}

	@Then("I am able to see my short title saved")
	public void I_am_able_to_see_my_short_title_saved() {
		alertscreen.verifyshorttitle(map.get("ShotTitle"));
	}
	
	@Then("I am able to navigate to toggle screen")
	public void I_am_able_to_navigate_to_toggle_screen() throws InterruptedException {
		Thread.sleep(10000);
		switchsscreen.toggletinted();
	}
}
