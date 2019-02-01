package QualityArc.Mobile;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.HomePage;

public class Login {

	private AndroidDriver<AndroidElement> driver;
	private HomePage homePage;

	public Login(AndroidDriver<AndroidElement> driver) {

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