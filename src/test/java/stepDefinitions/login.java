package stepDefinitions;

import java.util.HashMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.HomePage;

public class login {
	public World world;
	public AppiumDriver<?> driver;
	public HomePage homePage;
	private HashMap<String, String> map;

	@SuppressWarnings("unchecked")
	public login(World world) {
		this.world = world;
		driver = (AppiumDriver<?>) this.world.context.get("driver");
		homePage = new HomePage(world);
		map = (HashMap<String, String>) world.context.get("config");
	}

	@Given("I as a admin user navigate to Home page")
	public void i_as_a_admin_user_navigate_to_Home_page() {
		driver.get(map.get("OrangeURL"));
	}

	@When("I try to login with username and password")
	public void i_try_to_login_with_username_and_password() {
		homePage.enterUsername(map.get("Username"));
		homePage.enterPassword(map.get("Password"));
		homePage.clickLoginBtn();
	}

	@Then("I am logged in successfully")
	public void i_am_logged_in_successfully() {

		homePage.verifyLogin();
		// System.out.println("verify home page title");
	}

}
