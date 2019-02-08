package QualityArc.Mobile;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import pages.HomePage;

public class Login {

	private AppiumDriver<WebElement> driver;
	private HomePage homePage;

	public Login(AppiumDriver<WebElement> driver) {

		this.driver = driver;

		System.out.println("Starting Test");

	}

	@Test
	public void loginTest() throws MalformedURLException {
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
		homePage = new HomePage(driver);
		homePage.enterUsername("Admin");
		homePage.enterPassword("admin123");
		homePage.clickLoginBtn();

	}
}