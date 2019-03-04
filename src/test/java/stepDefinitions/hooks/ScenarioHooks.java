package stepDefinitions.hooks;

import io.appium.java_client.AppiumDriver;
import stepDefinitions.World;

public class ScenarioHooks {
	private World world;
	private AppiumDriver<?> driver;

	/*
	 * @SuppressWarnings("unchecked") public ScenarioHooks(World world) { this.world
	 * = world; driver = (AppiumDriver<WebElement>)
	 * this.world.context.get("driver"); }
	 * 
	 * @Before("@adminUserLoggedIn") public void login() { HomePage homePage = new
	 * HomePage(driver); homePage.loginWithDefaultCredentials(); }
	 */
}
