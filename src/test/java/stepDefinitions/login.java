package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.HomePage;

public class login {
	public World world;
	public AndroidDriver<AndroidElement> driver;
	public HomePage homePage;

	@SuppressWarnings("unchecked")
	public login(World world) {
		this.world = world;
		driver = (AndroidDriver<AndroidElement>) this.world.context.get("driver");
		homePage = new HomePage(driver);
	}

	String url = (String) this.world.context.get("URL");

	@Given("I as a admin user navigate to Home page")

	public void i_as_a_admin_user_navigate_to_Home_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);

	}

	@When("I try to login with username {string} and password {string}")
	public void i_try_to_login_with_username_and_password(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);
		homePage.enterUsername("Admin");
		homePage.enterPassword("admin123");
		homePage.clickLoginBtn();
	}

	@Then("I am logged in successfully")
	public void i_am_logged_in_successfully() {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("verify home page title");
	}

}
