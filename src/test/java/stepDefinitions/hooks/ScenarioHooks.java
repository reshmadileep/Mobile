package stepDefinitions.hooks;

import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.HomePage;
import stepDefinitions.World;

public class ScenarioHooks {
	private World world;
	private AndroidDriver<AndroidElement> driver;

	@SuppressWarnings("unchecked")
	public ScenarioHooks(World world) {
		this.world = world;
		driver = (AndroidDriver<AndroidElement>) this.world.context.get("driver");
	}

	@Before("@adminUserLoggedIn")
	public void login() {
		HomePage homePage = new HomePage(driver);
		homePage.loginWithDefaultCredentials();
	}
}
